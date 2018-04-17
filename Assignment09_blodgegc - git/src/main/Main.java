/***
 * Name: Greg Blodgett
 * Assignment number: 
 * Course #, and section: Course 2045, Section 1
 * Due date: 
 * Description: The main class that tests the grep class.
 * Citations: 
 * Stack overflow user TomC (https://stackoverflow.com/questions/163360/regular-expression-to-match-urls-in-java)
 * Anything else:
 */

package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import grep.Config;
import grep.Grep;

public class Main {

	public static void main(String[] args) {		
		//regularExpressionDemo();
		Config config = new Config("I:\\Assignment09_blodgegc\\TextFiles");
		config.setSearchString("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
		try {
			Grep.grep(config);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		config.setSearchString("(\\d\\d)[-/](\\d\\d)[-/](\\d\\d(?:\\d\\d)?$)");
		
		try {
			Grep.grep(config);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		config.setSearchString("(?i)Love");
		try {
			Grep.grep(config);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		config.setSearchString("[!@#$%^&*{}|<>]");
		try {
			Grep.grep(config);
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
	      //Expression must start with "www." and end with ".com"
	      pattern = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
	      matcher = pattern.matcher((CharSequence)"https://stackoverflow.com/questions/tagged/java");
	      if(matcher.find()) {System.out.println("Match found: " + matcher.group(0));}
	      else {System.out.println("9999");}
	      //Expression ignores case
	      pattern= Pattern.compile("(?i)Love");
	      matcher = pattern.matcher((CharSequence) "lOvE");
	      if(matcher.find()) {System.out.println("Match found: " + matcher.group(0));}
	      else {System.out.println("No match found");}
	      //Expression finds a date
	      pattern= Pattern.compile("^(\\d\\d)[-/](\\d\\d)[-/](\\d\\d(?:\\d\\d)?$)");
	      matcher = pattern.matcher((CharSequence) "12/30/1009");
	      if(matcher.find()) {System.out.println("Match found: " + matcher.group(0));}
	      else {System.out.println("No match found");}
	}

}
