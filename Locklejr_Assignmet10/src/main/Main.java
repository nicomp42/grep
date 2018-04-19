/***************************************
 * John Locklear
 * It2045C002
 * Assignment 10
 * Created by Bill Niicholson
 * ***************************
 * Regular Expressions and grep
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import grep.Grep;
/**
 * grep utility
 * @author Veteran
 *process the files 
 *@param file path the directory to begin searching in. it cannot be a sigle file, must be a derectory
 *@param searching the regular expression to match
 *@param recurse if true, delve into any sub directory 
 */
public class Main {

	public static void main(String[] args) {
		
		//regularExpressionDemo();
		
		try {
			
			Grep.grep("C:\\users\\Veteran\\test\\", "MAGNETO*", true);
			System.out.println("You found a mutant !");
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
