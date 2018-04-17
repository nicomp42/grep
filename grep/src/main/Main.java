/**
 * Assignment 09
 * @author Stephen Meckstroth
 * Description: An assignment to learn regex and implement grep commands using java
 * Due Date: Apr 17, 2018
 * Course: IT2045 Section 001
 * email: meckstss@mail.uc.edu
 * Citations: https://stackoverflow.com/questions/7569335/reverse-a-string-in-java
 * https://stackoverflow.com/questions/7459263/regex-whole-word
 */
package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import grep.Grep;

public class Main {

	public static void main(String[] args) {
		
		regularExpressionDemo();
		
		try {
			//Match case sensitive
			//Grep.grep("e:\\", "get", true, true, false, false);
			//Match case insensitive
			//Grep.grep("e:\\", "get", true, false, false, false);
			//Match case insensitive, and invert match (i.e.: TEG matches GET)
			//Grep.grep("e:\\", "get", true, false, true, false);
			
			//Match whole words only (i.e.: get does not get matched from the word forget.  get has to be surrounded by whitespace
			Grep.grep("e:\\", "like", true, false, false, true);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
	/***
	 * Demo the Regular Expression syntax
	 */
	private static void regularExpressionDemo() {
		  System.out.println("Regular Expression Demos...");
	      Pattern pattern = Pattern.compile("fish");
	      Matcher matcher = pattern.matcher((CharSequence)"The fish swims");
	      if (matcher.find( )) {
	    	  System.out.println("Match found:" + matcher.group(0));
	      } else {
	    	  System.out.println("NO match found.");
	      }
	      // The expression must be at the beginning of the string.
	      pattern = Pattern.compile("^fish");
	      matcher = pattern.matcher((CharSequence)"The fish swims");
	      if (matcher.find( )) {
	    	  System.out.println("Match found:" + matcher.group(0));
	      } else {
	    	  System.out.println("NO match found.");
	      }
	      // The expression must have 5 digits in a row
	      pattern = Pattern.compile("\\d{5}");			// It's actually \d{5}
	      matcher = pattern.matcher((CharSequence)"aaa 12345 bbbb");
	      if (matcher.find( )) {
	    	  System.out.println("Match found:" + matcher.group(0));
	      } else {
	    	  System.out.println("NO match found.");
	      }
	}
}
