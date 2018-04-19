/***************************************
 * Test greps
 * Daniel Cullen
 * cullendl@mail.uc.edu
 */
package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import grep.Grep;
import grep.Grep2;
import grep.Grep3;

public class Main {

	public static void main(String[] args) {

		try {
			System.out.println("**************** Searches for exact matches: ***********************");
			Grep.grep("E:/testFiles", "Bear", true);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	
	
	try {
		System.out.println("**************** Makes uppercase words lowercase: ***********************");
		Grep2.grep("E:/testFiles", "LAPTOP", true);
	} catch(Exception ex) {
		System.out.println(ex.getLocalizedMessage());
	}
	try {
		System.out.println("**************** Searches for strings that are 5 or more characters long: ***********************");
		Grep3.grep("E:/testFiles", "\\d{5}", true);
	} catch(Exception ex) {
		System.out.println(ex.getLocalizedMessage());
	}
	try {
		System.out.println("**************** Makes lowercase words uppercase: ***********************");
		Grep3.grep("E:/testFiles", "hello", true);
	} catch(Exception ex) {
		System.out.println(ex.getLocalizedMessage());
	}
}

}
