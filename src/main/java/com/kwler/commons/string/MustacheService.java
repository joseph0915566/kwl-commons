package com.kwler.commons.string;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class MustacheService {

	public String applyData(String template, Object data){

		try(
				Reader reader = new StringReader(template);
				Writer writer = new StringWriter();
				) {

			Mustache mustache = new DefaultMustacheFactory().compile(reader, null);
			mustache.execute(writer, data).flush();
			
			return writer.toString();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
