/*****************************************************
 *Name: Ben Tenhover
 *Assignment: Assignment 10
 *Due Date: 4/19/2018
 *Course/Section/Semester: 2045C/002/Spring 2018
 *Email: tenhovbe@mail.uc.edu
 *Citations: StackOverFlow.com, regexlib.com, in-class work, textbook
 *Description: Modify the grep project to change the behavior of grep at least 3 different ways
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
import grepSearchConditions.GrepSearchConditions;
/**
 * Main class to demonstrate grep search conditions
 * @author Started by Bill Nicholson, modified by Ben Tenhover
 *
 */
public class Main {

	public static void main(String[] args) {

		//	regularExpressionDemo();

		try {

			System.out.println("------------------------------Grep Regex Testing------------------------------" //Testing the Grep() method using regular expressions
					+ "\nSearch for patterns using regular expressions");

			System.out.println("\nTest A: Search for character sequence: " + "\"" + "Cat" + "\"" + " using the regular expression to ignore case: \n(?i)");
			System.out.println("\nFile and character sequence found:");
			Grep.grep("F:\\CompProgramming2\\tenhovbe_Assignment10\\grep\\textFiles\\", "(?i)Cat", true);

			System.out.println("\nTest B: Search for any legitimate domain name or hostname using the regular expression: \n^[a-zA-Z0-9\\\\-\\\\.]+\\\\.(com|org|net|mil|edu|COM|ORG|NET|MIL|EDU)$ ");
			System.out.println("\nFile and character sequence found:");
			Grep.grep("F:\\CompProgramming2\\tenhovbe_Assignment10\\grep\\textFiles\\", "^[a-zA-Z0-9\\-\\.]+\\.(com|org|net|mil|edu|COM|ORG|NET|MIL|EDU)$", true);

			System.out.println("\n\nTest C: Search for strong passwords which have a length of at least 8 characters, contains \nat least one "
					+ "uppercase and one lowercase letter, at least one numeric value, \nand at least one special character using the regular expression: \n(?=^.{8,}$)(?=.*\\\\d)(?=.*[!@#$%^&*]+)(?![.\\\\n])(?=.*[A-Z])(?=.*[a-z]).*$ ");
			System.out.println("\nFile and password found:");
			Grep.grep("F:\\CompProgramming2\\tenhovbe_Assignment10\\grep\\textFiles\\", "((?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$)", true);
/*
		    System.out.println("\n\n------------------------------GrepCaseInsensitive Testing------------------------------" // Testing the GrepCaseSensitive() method
					+"\nSearch for character sequences with case insensitivity");

			System.out.println("\nTest D: Search for character sequence: " + "\"" + "FiSh" + "\"" + " while ignorning case without having to use a regular expression.");
			System.out.println("\nFile and character sequence found:");
			GrepSearchConditions.grepCaseInsensitive("F:\\CompProgramming2\\tenhovbe_Assignment10\\grep\\textFiles\\", "FiSh", true);

			System.out.println("\nTest E: Search for character sequence: " + "\"" + "wHalE" + "\"" + " while ignorning case without having to use a regular expression.");
			System.out.println("\nFile and character sequence found:");
			GrepSearchConditions.grepCaseInsensitive("F:\\CompProgramming2\\tenhovbe_Assignment10\\grep\\textFiles\\", "whalE", true);
*/
/*
		    System.out.println("\n\n------------------------------GrepInverseCaseSensitive Testing------------------------------" // Testing the GrepInverseCaseSensitive() method
					+"\nSearch for words that don't contain these patterns or character sequences with case sensitivity");

			System.out.println("\nTest F: Search for strings that don't contain the lowercase letter a");
			System.out.println("\nFile and strings found:");
			GrepSearchConditions.grepInverseCaseSensitive("F:\\CompProgramming2\\tenhovbe_Assignment10\\grep\\textFiles\\", "a", true);
*/
/*
		    System.out.println("\n\n------------------------------GrepInverseCaseInSensitive Testing------------------------------" // Testing the GrepInverseCaseInSensitive() method
					+"\nSearch for strings that don't contain these patterns or character sequences with case insensitivity");

			System.out.println("\nTest G: Search for strings that don't contain the letter a, uppercase or lowercase");
			System.out.println("\nFile and strings found:");
			GrepSearchConditions.grepInverseCaseInsensitive("F:\\CompProgramming2\\tenhovbe_Assignment10\\grep\\textFiles\\", "a", true);

			System.out.println("\nTest H: Search in the passwords folder for passwords that are not strong, meaning they don't meet the following requirements: "
			+ "\nA length of at least 8 characters, contains at least one uppercase and one lowercase letter, at least one numeric value, \nand at least one special character");
			System.out.println("\nFile and passwords found:");
			GrepSearchConditions.grepInverseCaseInsensitive("F:\\CompProgramming2\\tenhovbe_Assignment10\\grep\\textFiles\\passwords\\", "((?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$)", true);
*/
/*	  
			System.out.println("\n\n------------------------------GrepFileName Testing------------------------------" // Testing the GrepFileName() method
					+"\nSearch for character sequences and return just the file(s) and file path(s) that they exist in");
			System.out.println("\nTest I: Search for the character sequence " + "\"" + "ch" + "\"" + ".");
			System.out.println("\nFile(s) and file path(s) found:");
			GrepSearchConditions.grepFileName("F:\\CompProgramming2\\tenhovbe_Assignment10\\grep\\textFiles\\", "ch", true);
*/  
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
}

/***
 * Demo the Regular Expression syntax
 */

/*private static void regularExpressionDemo() {
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
 */
