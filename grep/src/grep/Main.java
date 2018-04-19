/***************************************
 * Regular Expressions and grep
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
/**
 * Assignment 10
 * 34-IT-2045C: Computer Programming II
 * Spring semester 2018
 * This Program will compute equations using regex
 * @author Willispd
 * Due 4/19/2018
 * Dictionary.txt came from https://github.com/dwyl/english-words
 */
package grep;


import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException{
		try {
			AltGrepFileReader.Alt("Dictionary.txt", "(?i)ZYgote");//search using the file reader
				System.out.println("++++++++++++ Done searching using Case_insensitive");
			AltGrepFileReader.Alt("Dictionary.txt", "(?s)aaaah");
				System.out.println("++++++++++++ Done searching using DOTALL");
			AltGrepFileReader.Alt("Dictionary.txt", "(?u)abasing");
				System.out.println("++++++++++++ Done searching using Unicode_Case");
				System.out.println("Finished reading from file: Starting Flash Drive search");
			Grep.grep("F:\\", "(?i)ZYgote", true);//this will compile for the inclass demo
				System.out.println("++++++++++++ Done searching the flash drive using Case_insensitive");
			Grep.grep("F:\\", "(?s)aaaah", true);
				System.out.println("++++++++++++ Done searching the flash drive using DOTALL");
			Grep.grep("F:\\", "(?u)abasing", true);
				System.out.println("++++++++++++ Done searching the flash drive using Unicode_Case");
				System.out.println("++++++++++++ Done searching the flash drive");

		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
}

