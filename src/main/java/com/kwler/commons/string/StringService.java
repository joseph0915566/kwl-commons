package com.kwler.commons.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class StringService {

	public String replace(String original, Pattern pattern, String replacement){
		return pattern.matcher(original).replaceAll(Matcher.quoteReplacement(replacement));
	}
	
	public String[] split(String origin, Pattern pattern){
		return pattern.split(origin, 0);
	}
	
	public boolean notEmpty(String string){
		return !(string == null || string.isEmpty());
	}

}
