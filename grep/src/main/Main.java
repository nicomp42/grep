/***************************************
 * Ash Huston
 * Assignment 09
 * Course #, Section: Course 2045 Section 01
 * Due 04/17/2018
 * This class is used to test the grep method.
 */
package main;

import grep.Grep;
import grep.GrepMode;

public class Main {

	public static void main(String[] args) {
		
		//8 test cases
		try {
			System.out.println("");
			System.out.println("Test 1");
			Grep.grep("G:\\Stories", "bean", true, GrepMode.DEFAULT);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		try {
			System.out.println("");
			System.out.println("Test 2");
			Grep.grep("G:\\Stories", "AmErIcA", true, GrepMode.NOCASE);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		try {
			System.out.println("");
			System.out.println("Test 3");
			Grep.grep("G:\\Stories", "One", true, GrepMode.BEGINLINE);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		try {
			System.out.println("");
			System.out.println("Test 4");
			Grep.grep("G:\\Stories", "meat", true, GrepMode.DEFAULT);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		try {
			System.out.println("");
			System.out.println("Test 5");
			Grep.grep("G:\\Stories", "large", true, GrepMode.NOCASE);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		try {
			System.out.println("");
			System.out.println("Test 6");
			Grep.grep("G:\\Stories", "man", true, GrepMode.ENDLINE);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		try {
			System.out.println("");
			System.out.println("Test 7");
			Grep.grep("G:\\Stories", "All", true, GrepMode.DEFAULT);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		try {
			System.out.println("");
			System.out.println("Test 8");
			Grep.grep("G:\\Stories", "Eat", true, GrepMode.DEFAULT);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
}
