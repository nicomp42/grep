/***************************************
 * Jennifer Palazzolo
 * AssignmentPracticeInput
 * 04/17/2018
 * Computer Programming II 2045C/001/Spring2018
 * Citations:
 * Calculates grep
 */
package main;

import java.io.IOException;

import grep.Grep;

public class Main {

	public static void main(String[] args) throws IOException {
		
		regularExpressionDemo();
		
		try {
			Grep.grep("trapping.txt", "cla*", true);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
	/***
	 * Demo the Regular Expression syntax
	 * @throws IOException 
	 */
	private static void regularExpressionDemo() throws IOException {
		//The expression can be anywhere in the file and is not case sensitive
		Grep.grep("trapping.txt", "and", true);

	    // The expression must be at the end of the string.
	    Grep.grep("trapping.txt", "and$", true);

	    // The expression can not be in the search line
	    Grep.grep("trapping.txt", "-v and", true);
	}
}
