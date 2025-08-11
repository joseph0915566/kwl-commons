package com.kwler.commons.io;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class PropertyService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyService.class);
	
	public Properties load(String primaryLocation, String... propertiesfileNames){

		Properties properties = new Properties();		
		
		for(String propertiesFileName : propertiesfileNames){

			try(InputStream is = new FileInputStream(FileSystems.getDefault().getPath(primaryLocation, propertiesFileName).toFile())) {
				properties.load(is);
				LOGGER.info(propertiesFileName + " loaded successfully from " + primaryLocation);
			} catch (Exception e) {
				
				LOGGER.error("Failed loading " + propertiesFileName + " from " + primaryLocation, e);

				try(InputStream is = getClass().getResourceAsStream("/" + propertiesFileName)) {
					properties.load(is);
					LOGGER.info(propertiesFileName + " loaded successfully from classpath");
				} catch (Exception exception) {
					throw new RuntimeException("Failed loading " + propertiesFileName + " from classpath", exception);					
				}
				
			}
			
		}
		
		return properties;
		
	}
	
}
