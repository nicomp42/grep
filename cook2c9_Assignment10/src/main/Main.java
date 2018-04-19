/***************************************
 * Regular Expressions and grep
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 * 
 */
package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import grep.Grep;

public class Main {

	/**
	 * Name: Connor Cook
	 * Assignment: Assignment10
	 * Class: Computer Programming 2, Bill Nicholson, UC Clermont Spring Semester 2018
	 * Description: This is a demonstration on "grep"s in Java, specifically how to use .replace() 
	 * to replace one string in a file with another. I use it here to change longer names that are 
	 * commonly shortened, such as William --> Will, Joshua --> Josh ect. 
	 * 
	 * 
	 * This program 
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		
		regularExpressionDemo();
		
		String location = ("C:\\\\Users\\\\Connor\\\\Desktop\\\\cook2c9_Assignment10");		//Sets the file path that is being searched
		
		/*
		 * The following test cases search the "location," which is set to the desired file path, and 
		 * is given a searchString as well as a recursion. The file then tries to get the information from 
		 * the grep class and prints an error message if unable to do so. 
		 */
		try {
			Grep.grep(location, "William", true);			//Sets the searchString to "William" It will check anything in the file that is given as "location"
		} catch(Exception ex) {								
			System.out.println(ex.getLocalizedMessage());	//Prints an error message if unable to find a match
		}
		
		try {
			Grep.grep(location, "Joshua", true);			//Sets the searchString to "Joshua" It will check anything in the file that is given as "location"
		} catch(Exception ex) {	
			System.out.println(ex.getLocalizedMessage());	//Prints an error message if unable to find a match
		}
		
		try {
			Grep.grep(location, "Johnathan", true);			//Sets the searchString to "Johnathan" It will check anything in the file that is given as "location"
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());	//Prints an error message if unable to find a match
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
