package com.kwler.commons.string;

import java.util.regex.Pattern;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class Patterns {

	//popular patterns
	public static final Pattern DOT_PATTERN = Pattern.compile("\\.");
	public static final Pattern COMMA_PATTERN = Pattern.compile(",");
	public static final Pattern BLANK_PATTERN = Pattern.compile("");
	public static final Pattern INVISIBLE_CHARACTERS_PATTERN = Pattern.compile("\\s");
	public static final Pattern DOUBLE_QUOTE_PATTERN = Pattern.compile("\"");
	
	public static final Pattern EMAIL_PATTERN = Pattern.compile("[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})");
	
}
