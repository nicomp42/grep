/***************************************
 * Regular Expressions and grep
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 * 
 * Heavily Modified by Tucker Godsey
 * 
 * This is the main class. It displays user popups and either starts the tests or starts a search
 */
package main;

import grep.Config;
import grep.Grep;

public class Main {

	public static void main(String[] args) {
		Boolean testPassed = false;
		int totalPass = 0;
		
		// Attempt to find the word "BMW"
		Config config = new Config("G:\\Java Stuff\\grep\\src\\textFiles", "BMW", true, true, false, false);
		try {
			// Search the dir for any string 
			System.out.println("Testing case 1");
			if (Grep.grep(config).equals("BMW"))  {
				testPassed = true;
				totalPass++;
			} else {
				testPassed = false;
			}
			System.out.println("Test Pass: " + testPassed + " - Total Score: " + totalPass);
			
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		// Attempt to find the word "Bass" with case sensitivity on
		config = new Config("G:\\Java Stuff\\grep\\src\\textFiles", "Bass", true, true, false, false);
		try {
			// Search the  dir for any string
			System.out.println("Testing case 2");
			if (Grep.grep(config).equals("Bass"))  {
				testPassed = true;
				totalPass++;
			} else {
				testPassed = false;
			}
			System.out.println("Test Pass: " + testPassed + " - Total Score: " + totalPass);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		// Attempt to find the word "bass" with case sensitivity off
		config = new Config("G:\\Java Stuff\\grep\\src\\textFiles", "bass", true, false, false, false);
		try {
			// Search the dir for any string
			System.out.println("Testing case 3");
			if (Grep.grep(config).equals("Bass"))  {
				testPassed = true;
				totalPass++;
			} else {
				testPassed = false;
			}
			System.out.println("Test Pass: " + testPassed + " - Total Score: " + totalPass);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		// Attempt to find words with the letter "b" in the beginning, regardless of caps
		config = new Config("G:\\Java Stuff\\grep\\src\\textFiles", "b", true, false, true, false);
		try {
			// Search the dir for any string
			System.out.println("Testing case 4");
			if (Grep.grep(config).equals("BMWBassBluegill"))  {
				testPassed = true;
				totalPass++;
			} else {
				testPassed = false;
			}
			System.out.println("Test Pass: " + testPassed + " - Total Score: " + totalPass);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		// Attempt to find words with the letter "s" in the beginning, regardless of caps
		config = new Config("G:\\Java Stuff\\grep\\src\\textFiles", "s", true, false, true, false);
		try {
			// Search the dir for any string 
			System.out.println("Testing case 5");
			if (Grep.grep(config).equals("SubaruScionSamsungSony"))  {
				testPassed = true;
				totalPass++;
			} else {
				testPassed = false;
			}
			System.out.println("Test Pass: " + testPassed + " - Total Score: " + totalPass);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		// Attempt to find words that end with the letter "s" regardless of caps
		config = new Config("G:\\Java Stuff\\grep\\src\\textFiles", "s", true, false, false, true );
		try {
			// Search the dir for any string 
			System.out.println("Testing case 5");
			if (Grep.grep(config).equals("BassOnePlus"))  {
				testPassed = true;
				totalPass++;
			} else {
				testPassed = false;
			}
			System.out.println("Test Pass: " + testPassed + " - Total Score: " + totalPass);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		System.out.println("Total tests passed: " + totalPass + "/6");
	}
	
}
