/**
 * Jacob Schaefer
 * Grep Utility
 */
package grep;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * A program that shows the workings of a grep utility
 * @author Jacob Schaefer
 * Computer programming 2
 * Section 02
 * Due date: 4/19/2018
 * Email: schaefj8@mail.UC.edu
 * Citation - Original source code: Bill Nicholson
 */
public class Grep {
	/**
	 * A method that will be used to list the filePath and String searched for
	 * @param filePath The path to the specified file
	 * @param searchString The String to search for
	 * @param recurse To repeat set operations on file
	 * @throws IOException
	 */
	public static void grep(String filePath, String searchString, boolean recurse) throws IOException {
		
		/**
		 * A Path set in a Stream sequence to collect a list of files and print the grepped string
		 */
		// for loop to print all paths of a file
		// Create new File myFile to list path toString
		// if myFile is a directory recurse file and search file for string
		// if myFile is false and not recurse call scan method for myFile and searchString
		Path myPath = Paths.get(filePath);
		try (Stream<Path> entries = Files.list(myPath)) {
			List<Path> paths = entries.collect(Collectors.toList());
			for (Path path : paths) {
				File myFile = new File(path.toString());
				if (myFile.isDirectory()) {
					if (recurse) {
						grep(myFile.toString(), searchString, true);
					}
				} else {
				    scan(myFile, searchString);  
				}
			}
		}
	}
	/***
	 * A method that scans a file for a string
	 * @param file The file to scan
	 * @param searchString The string to search for
	 * @throws FileNotFoundException 
	 */
	private static void scan(File file, String searchString) throws FileNotFoundException {
	      
	      /**
	       * Pattern object pattern created to compile searchString and make it case insensitive
	       */
	      Pattern pattern = Pattern.compile(searchString, Pattern.CASE_INSENSITIVE);
	      
	      /**
	       * Try catch block that reads a text file for specified string
	       */
	      // line declared as integer to count lines at which a string occurs
	      // while loop that reads the file while it is not blank (null)
	      // Create Matcher matcher to match the pattern in the file
	      // while loop that while matcher finds the pattern
	      // if pattern length is not zero output of the string and any spaces replaced with a comma, how exciting
	      // When length is not zero matcher start and end show the starting and ending index of specified String
	      // else "No Match" ouput
	      // if the String is contained in the file output the file toString, line, and buffer
	      // Add 1 to line per each line passed through
	      // close the BufferedReader when finished
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String buffer;
			int line = 0;		// Line number in the file that we are reading
			while ((buffer = br.readLine()) != null) {
			      // Now create matcher object.
			      Matcher matcher = pattern.matcher((CharSequence)buffer);
			      while(matcher.find()) {
			    	  if(matcher.group().length() != 0) {
			    	  // RegEx Match
			    	  System.out.println(file.toString() + ": " + "Starting index " + line + ": " + buffer.replaceAll("[\\s]", ", "));
			    	  System.out.println("Found at: " + matcher.start() + " - " + matcher.end());
			    	  }
			       else {
			    	 // System.out.println("No Match");
			      }
				if (buffer.contains(searchString)) {
					System.out.println(file.toString() + ": " + line + ": " + buffer);
					
				}
			  }
				line++;
			}
			br.close();
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	
	}
}
