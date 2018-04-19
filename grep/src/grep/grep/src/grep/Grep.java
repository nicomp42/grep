/*
Edited By:
Name: Alex Hargett
Class Number and Section: Programming 2 (002)
Assignment #: 10
Due date: 4/18/2018
Description: Add three features to our grep file checker
*/
/************************************************
 * grep utility
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
/**
 * Grep Utility Edit
 * @author hargetaj
 * Edited to include three additional features to grep's functionality
 */
package grep;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * Grep Utility
 * @author nicomp
 *processes the files 
 *create new class to adjust the grep
 */
public class Grep {
	public static void grep(GrepConfig search) throws IOException {//Changed so all arguments are located in their own class
		Path myPath = Paths.get(search.getFilePath());//sets the path where we find our files
		try (Stream<Path> entries = Files.list(myPath)) {
			List<Path> paths = entries.collect(Collectors.toList());
			for (Path path : paths) {
				//System.out.print(path.toString());
				File myFile = new File(path.toString());
				if (myFile.isDirectory()) {
				    //System.out.println("  It's a directory");
					if (search.isRecurse()) {
						search.setFilePath(myFile.toString());
					}
				} else {
				    //System.out.println("  It's a file");
				    scan(myFile, search.getSearchString(), search);//send our in information of location and what we are looking for to the scan class which will read the files
				}
				//System.out.println(path.toString() + ", " + path.getFileName() + ", " + path.getName(0) + ", " + path.getClass().toString());
			}
			//System.out.println(paths.toString());
		}
	}
	/***
	 * Scan a file for a string in a single file, string can be a reg expression
	 * @param file The file to scan
	 * @param searchString The string to search for
	 */
	private static void scan(File file, String searchString, GrepConfig search) {
		//The following hashtable is used to store all words read off the files, and will be used to help our previous and next grep arguments
		  Hashtable<Integer, String> readWords = new Hashtable<Integer, String>();
		//ArrayList to keep track of line numbers that are printed
		  ArrayList<Integer> lineCount = new ArrayList<Integer>();
	      // Create a Pattern object
	      Pattern pattern = Pattern.compile(searchString);
	      //the following if statement creates a pattern that is case indiscriminate when the proper grep argument is set to true
	      if (search.isCaseInsensitive() == true) {pattern = Pattern.compile(searchString, Pattern.CASE_INSENSITIVE);}
	      
		try {
			FileReader fr = new FileReader(file);//reads file
			BufferedReader br = new BufferedReader(fr);//reads lines of the file
			String buffer;//holds each line of text in the file
			int line = 1;		// Line number in the file that we are reading
			while ((buffer = br.readLine()) != null) {//loops while that files still have lines
			      // Now create matcher object.
			      Matcher matcher = pattern.matcher((CharSequence)buffer);//checks for matches with the search words
			      if (matcher.find( )) {//if match is found it is printed
			    	  // RegEx Match
			    	  System.out.println(file.toString() + ": " + line + ": " + buffer);// + " => " + m.group(0));
			    	  lineCount.add(line);//adds the line number to an arraylist to call back when searching the next item
			    	  if (search.isPrevious()) {//checks if the Previous argument is true and should be active
			    		  System.out.println("The previous line reads: " + readWords.get(line - 1) + "| Which is line: "+(line - 1)+"<<");
			    		  System.out.println();//prints the previous lines of text
			    	  }
			      } else {
			    	 // System.out.println("No Match");
			      }
			    readWords.put(line, buffer);//Adds new lines to the hashtable, to give previous results
				line++;//adds to the line counter
			}
			br.close();//closes the buffered reader
			if (search.isNext()) {//checks if the next argument is true
				for (int i = 0; i < lineCount.size(); i++) {//loops through lines that are returned
					System.out.println("The line after line " + lineCount.get(i) + " reads: " + 
					readWords.get(lineCount.get(i) + 1) + "| Which is line: "+(lineCount.get(i) + 1)+">>");//prints the next line in the sequence
				}
			}
		} catch (Exception ex) {//catches when machine broke
			System.out.println(ex.getLocalizedMessage());
		}	
	}
}
