/***************************************
 * Jacob Schaefer
 * Regular Expression and Grep Utility demo
 */
package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import grep.Grep;

/**
 * A program that shows Grep Utility in action and Regular Expression example demo.
 * @author Jacob Schaefer
 * Computer programming 2
 * Section 02
 * Due date: 4/19/2018
 * Email: schaefj8@mail.UC.edu
 * Citation - Original source code: Bill Nicholson
 */
public class Main {

	public static void main(String[] args) {
		/**
		 * calling regularExpressionDemo 
		 */
		// Output of tested regular expressions in a demo
		regularExpressionDemo();
		
		/**
		 * Try catch block that uses the Grep Utility
		 */
		// Try block calls the Grep Utility method grep
		// if filepath, a string, and recursed is true are listed a file will be searched for specified string else catch exception
		// First testing to show all 's' in a made directory GrepExample within file DogStuff
		// Second testing to show all 'F' in a made directory GrepExample within file OfficeStuff
		// Third testing to show all 'a' in a made directory GrepExample within file CarStuff
		try {
			Grep.grep("D:\\GrepExample\\DogStuff", "s*" , true);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		// Line output to separate testing try catch blocks to help section what we read a bit better
		System.out.println("===============================================================================");
		
		try {
			Grep.grep("D:\\GrepExample\\OfficeStuff", "F*" , true);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		// Line output to separate testing try catch blocks to help section what we read a bit better
		System.out.println("===============================================================================");
		
		try {
			Grep.grep("D:\\GrepExample\\CarStuff", "a*" , true);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
	
	/**
	 * Demo the Regular Expression syntax
	 */
	// Testing of each regular expression demo
	private static void regularExpressionDemo() {
		  // Output stating the Regular Expression Demos
		  System.out.println("Regular Expression Demos...");
		  
	      /**
	       * Testing for "fish"
	       */
		  // if fish is contained within the string test passes else, fails.
	      Pattern pattern = Pattern.compile("fish");
	      Matcher matcher = pattern.matcher((CharSequence)"The fish swims");
	      if (matcher.find( )) {
	    	  System.out.println("Match found:" + matcher.group(0));
	      } else {
	    	  System.out.println("NO match found.");
	      }
	      
	      /**
	       * Testing for "fish" to start at the beginning of the string
	       */
	      // if "fish" starts at the beginning of the string the test passes else, fails.
	      pattern = Pattern.compile("^fish");
	      matcher = pattern.matcher((CharSequence)"fish can be all kinds of colors");
	      if (matcher.find( )) {
	    	  System.out.println("Match found:" + matcher.group(0));
	      } else {
	    	  System.out.println("NO match found.");
	      }
	      
	      /**
	       * Testing that '5' digits in a row are within the string
	       */
	      // if '5' digits in a row are contains within the string the test passes else, fails.
	      pattern = Pattern.compile("\\d{5}");
	      matcher = pattern.matcher((CharSequence)"aaa 12345 bbbb");
	      if (matcher.find( )) {
	    	  System.out.println("Match found:" + matcher.group(0));
	      } else {
	    	  System.out.println("NO match found.");
	      }
	}
}
