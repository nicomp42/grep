/*
Edited By:
Name: Alex Hargett
Class Number and Section: Programming 2 (002)
Assignment #: 10
Due date: 4/18/2018
Description: Add three features to our grep file checker
*/
/***************************************
 * Regular Expressions and grep
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
/**
 * Grep Utility Edit
 * @author hargetaj
 * Edited to include three additional features to grep's functionality
 */
package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import grep.Grep;
import grep.GrepConfig;

public class Main {
/**
 * This main will be used house test showing the new functionality of grep
 * @param args- prints to the system
 */
	public static void main(String[] args) {
		//Object for a control test case, were none of my additions are in affect
		GrepConfig controlCase = new GrepConfig("I:\\Eclipsidoodles\\grep\\GrepTextFiles", "Snake", true, false, 
				false, false);
		//Object to test the ability of my case indiscriminate addition
		GrepConfig lowerCaseTest = new GrepConfig("I:\\Eclipsidoodles\\grep\\GrepTextFiles", "snake", true, true, 
				false, false);
		//Object to test if my additions shows the previous line to that of the results
		GrepConfig previouslineTest = new GrepConfig("I:\\Eclipsidoodles\\grep\\GrepTextFiles", "Snake", true, false, 
				true, false);
		//Object to test if my addition shows that value after results of our search
		GrepConfig nextLinesTest = new GrepConfig("I:\\Eclipsidoodles\\grep\\GrepTextFiles", "Snake", true, false, 
				false, true);
		//System.out.println(controlCase.getFilePath());
		//regularExpressionDemo();
		
		try {
			//Search the \temp directory for any string starting with cla recures into any directories contained in \temp
			System.out.println("--Contol Group(Just a basic search)--");
			Grep.grep(controlCase);//Control Case where none of my additions are in affect
			System.out.println("_____________________________________________________________________");
			System.out.println();
			System.out.println("--Case Insensistive Test--");
			Grep.grep(lowerCaseTest);//Tests if the search become case indiscriminate
			System.out.println("_____________________________________________________________________");
			System.out.println();
			System.out.println("--Previous Line Test--");
			Grep.grep(previouslineTest);//Test if previous items are displayed
			System.out.println("_____________________________________________________________________");
			System.out.println();
			System.out.println("--Next Line Test--");
			Grep.grep(nextLinesTest);//Test if the line after the result is shown
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
	/***
	 * Demo the Regular Expression syntax
	 */
	@SuppressWarnings("unused")
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
