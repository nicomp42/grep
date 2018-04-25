/***************************************
 * Regular Expressions and grep
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
package main;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import configuration.Configuration;
import grep.Grep;

public class Main {
/**
 * This is the main that tests the Grep and regular expressions. Modified by Tiffany Litteral 4/17/18
 * @param args
 */
	public static void main(String[] args) {
		 /******
	       * Tiffany's part of the main.
	       * I decided to use text files of common fairy tales
	       * I searched for:
	       *  	The phrase "Once upon a Time" at the beginning 
	       * 	The words "The End" at the end 
	       * 	Numbers in more than 3 digits.
	       * 
	       */
		// Find numbers more than three digits 
		Configuration beginning= new Configuration("E:\\Workspace\\littertm_GREP\\src\\textFiles\\","(?i) far away", false);
		// Find the word evil or devil 
		Configuration ending= new Configuration("E:\\Workspace\\littertm_GREP\\src\\textFiles\\", "(?i) evil|devil", false);
		//Find more than 3 digits
		Configuration digits = new Configuration("E:\\Workspace\\littertm_GREP\\src\\textFiles", "\\d{4}", false);
		try {
			Grep.grep(beginning);
			Grep.grep(ending);
			Grep.grep(digits);
		} catch (IOException e) {

			e.printStackTrace();
		}
	

		
		/*regularExpressionDemo();
		
		try {
			Grep.grep("c:\\temp\\", "cla*", true);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}*/
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
	      // Take
	      pattern = Pattern.compile("\\p{fish}");
	      matcher = pattern.matcher((CharSequence)"");
	  
	  
	     
	      
	   
	}
}
