/***************************************
 * Regular Expressions and grep
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
/******
 * Name: Ian Schwettman
 * Assignment: Assignment10
 * Due Date: 4/19/2018
 * Description: A main method that tests the grep method and all of it's different functions.
 * Class Number & Section: IT2045C
 */
package main;

import grep.Grep;

public class Main 
{
	/**
	 * This main tests the grep method in the Grep Class.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * Try a bunch of tests that will search the filePath for a searchString.
		 */
		try 
		{
			Grep.grep("d:/test", "Acura", true, 0);		// Just some tests of the basic grep method that doesn't do anything fancy.  Should return "Acura"
			Grep.grep("d:/test", "Ram", true, 0);		// Should return "Ram"
			Grep.grep("d:/test", "o", true, 0);			// Should return all car brands in the text file that have a lowercase "o" in their name.
			System.out.println("End of testing for the basic grep method.");
			Grep.grep("d:/test", "aCuRa", true, 1);		// The integer at the end represents the function, 1 is case insensitive, 2 prints all strings that DON'T include the search string, and 3 is an exact search that will not print anything if the searchstring is not found exactly as entered somewhere in the filePath.
			Grep.grep("d:/test", "AcUrA", true, 1);		// All three of these tests should return the match they find, which in this case should be "Acura"
			Grep.grep("d:/test", "ACURA", true, 1);
			Grep.grep("d:/test", "S", true, 1);			// Should print all car brands in the text file with an uppercase or lowercase "S" in their name.
			System.out.println("End of testing for the case insensitive grep method.");
			Grep.grep("d:/test", "Acura", true, 2);		// Should return everything that does not include "Acura"
			System.out.println("------------------------------");		// Just spacers to make the console easier to read.
			Grep.grep("d:/test", "Ram", true, 2);		// Should return everything that does not include "Ram"
			System.out.println("------------------------------");		// Just spacers to make the console easier to read.
			Grep.grep("d:/test", "Kia", true, 2);		// Should return everything that does not include "Kia"
			System.out.println("------------------------------");		// Just spacers to make the console easier to read.
			Grep.grep("d:/test", "a", true, 2);			// Should return all car brands that do not have a lowercase "a" in their name.
			System.out.println("End of testing for the inverse search grep method.");
			Grep.grep("d:/test", "Ra", true, 3);		// Should not print anything.
			Grep.grep("d:/test", "Acu", true, 3);		// Should not print anything.
			Grep.grep("d:/test", "Suzuki", true, 3);		// Should print Suzuki.
			Grep.grep("d:/test", "suzuki", true, 3);		// Should not print anything, the exact search is case sensitive.
			System.out.println("End of testing for the exact search grep method.");
		}
		catch(Exception ex) // Catch any errors that may occur and print them to console.
		{
			System.out.println(ex.getLocalizedMessage());
		}
	}
}
