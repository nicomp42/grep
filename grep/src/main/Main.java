/* Jacob Lynch 
 * 2045c 002 
 * Lynch2jw_Assignment10
 * April 19th 2018
 * Create 3 new regular expressions 
 *
 */

/***************************************
 * Regular Expressions and grep
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import grep.Grep;

public class Main {
/**
 * The main method calls the regular expressions methods 
 * @param args
 */
	public static void main(String[] args) {
		
		regularExpressionDemo();
		
		try {
			// Has to end in a slash
			Grep.grep("c:\\users\\marlerkw\\test\\", "rattler*", true);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		// Calling my method 
		myRegularExpressions();
		
		try {
			Grep.grep("E:\\Grep\\", "*E", true);
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
	/**
	 * This is the method with 
	 * my regular expressions 
	 * 
	 */
	private static void myRegularExpressions () {
		
		System.out.println();
		System.out.println("First Regular expression");
		
		// This is the test case using the string spelled as Jacob.
		Pattern testName1 = Pattern.compile("Ja(c|k)ob"); // This regular expression allows Jacob to be spelled also as Jakob
	      Matcher matcherTest1 = testName1.matcher((CharSequence)"Jacob Josh Jadob");
	      if (matcherTest1.find( )) {
	    	  System.out.println("Name found:" + matcherTest1.group(0));
	      } else {
	    	  System.out.println("Name not accepted.");
	      }
	      
	     // This is the test case using the string spell Jakob. 
	    Pattern testName2 = Pattern.compile("Ja(c|k)ob"); // This regular expression allows Jacob to be spelled also as Jakob
	      Matcher matcherTest2 = testName2.matcher((CharSequence)"Jacdw Jakob Jadob");
	      if (matcherTest2.find( )) {
	    	  System.out.println("Name found:" + matcherTest2.group(0));
	      } else {
	    	  System.out.println("Name not accepted.");
	      }  
	      
	     // This is the test case just spelling the name jacob/jakob differnet ways 
	    Pattern testName3 = Pattern.compile("Ja(c|k)ob"); // This regular expression allows Jacob to be spelled also as Jakob
	      Matcher matcherTest3 = testName3.matcher((CharSequence)"Jalob Jackob Jabob");
	      if (matcherTest3.find( )) {
	    	  System.out.println("Name found:" + matcherTest3.group(0));
	      } else {
	    	  System.out.println("Name not accepted.");
	      }  
	      
	      System.out.println();
	      System.out.println("Second Regular expression");
	    
	      // This is the test for a word length 
	    Pattern testLength = Pattern.compile("[A-Za-z]{5,10}"); // This regular expression looks for a word 5 through 10 charcters 
	      Matcher lengthTest = testLength.matcher((CharSequence)"George Josh John");
	      if (lengthTest.find( )) {
	    	  System.out.println("Word with Length between 5-10:" + lengthTest.group(0));
	      } else {
	    	  System.out.println("Word with Length not between 5 - 10 characters.");
	      }    
	     
	      // This is my third Expression 
	      System.out.println();
	      System.out.println("Third regular expression");
	     
	      
	    Pattern testLength2 = Pattern.compile("[A-Za-z]{10,30}"); // This regular expression looks for a word 5 through 10 charcters 
	      Matcher lengthTest2 = testLength2.matcher((CharSequence)"California Ohio Georgia");
	      if (lengthTest2.find( )) {
	    	  System.out.println("Word with Length between 10-30:" + lengthTest2.group(0));
	      } else {
	    	  System.out.println("Word with Length not between 10 -30 characters.");
	      }   
	      
	      		
	}
		 	
}
