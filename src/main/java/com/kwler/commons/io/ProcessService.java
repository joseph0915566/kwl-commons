package com.kwler.commons.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class ProcessService {
	
	private static final String CONSOLE_PREFIX = "<kwl-result>";
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessService.class);

	public List<List<String>> execute(String jobId, int timeOut, TimeUnit timeUnit, File startingFolder, String... command) throws InterruptedException{

		//second array is not used anymore
		List<List<String>> result = new ArrayList<>();
		File dumpOutput = null;
		File dumpError = null;
		try {
			
			dumpOutput = File.createTempFile("dump-output-" + jobId + "-" + System.currentTimeMillis(), null);
			dumpOutput.deleteOnExit();

			dumpError = File.createTempFile("dump-error-" + jobId + "-" + System.currentTimeMillis(), null);
			dumpError.deleteOnExit();

			LOGGER.info("Constructing Process Runner");
			
			ProcessBuilder builder = new ProcessBuilder(command).redirectError(dumpError).redirectOutput(dumpOutput);
			if(startingFolder != null) builder.directory(startingFolder.getAbsoluteFile());

			LOGGER.info("Process Runner started");
			
			Process p = builder.start();			
			boolean finished = p.waitFor(timeOut, timeUnit);

			LOGGER.info("Process Runner finished, reading results");
			
			result.add(readFile("Output Stream", dumpOutput));
			result.add(readFile("Error Stream", dumpError));
			
			if (!finished) {

				LOGGER.info("Process Runner took too long, forcing termination");

				p.destroy();
				p.waitFor();
				
			}		
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {

			LOGGER.info("Removing dump files");
			
			if(dumpOutput != null) dumpOutput.delete();
			if(dumpError != null) dumpError.delete();
			
		}
		
		return result;
		
	}
	
	public List<String> readFile(String streamName, File file) throws IOException{
		
		List<String> inputLines = new ArrayList<>();		
		try (InputStream is = new FileInputStream(file)) {

			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			while((line = reader.readLine()) != null){
				LOGGER.info(streamName + " --> " + line);	
				if(line.startsWith(CONSOLE_PREFIX)) inputLines.add(line);
			}
			
		}
		
		return inputLines;
		
	}
	
}