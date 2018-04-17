/***************************************
 * Ash Huston
 * Assignment 09
 * Course #, Section: Course 2045 Section 01
 * Due 04/17/2018
 * This class contains the grep method which is used to sift through text files and directories and searches them for a string.
 * It's behavior is altered by the GrepMode chosen.
 * Citations: Bill Nicholson wrote this originally and I edited/ expanded it. I also use this page to decide what Regular Expressions I could use.https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
 */
package grep;

import java.io.BufferedReader;
import java.io.File;
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

public class Grep {
	/**
	 * @param filePath Filepath of the directories or files to be scanned.
	 * @param searchString The string to search for
	 * @param recurse True if you wish for the scanner to go into directories
	 * @param mode Additional functions. NOCASE, BEGINLINE, and NOMATCH alter the effects of the method. DEFAULT leaves it as normal.
	 * @throws IOException
	 */
	public static void grep(String filePath, String searchString, boolean recurse, GrepMode mode) throws IOException {
		Path myPath = Paths.get(filePath);
		try (Stream<Path> entries = Files.list(myPath)) {
			List<Path> paths = entries.collect(Collectors.toList());
			for (Path path : paths) {
				File myFile = new File(path.toString());
				if (myFile.isDirectory()) {
					if (recurse) {
						grep(myFile.toString(), searchString, true, mode);
					}
				} else {
					//Apply a RegEx to the search string based on the GrepMode
				    if(mode == GrepMode.NOCASE) {
				    	searchString = "(?i)" + searchString;
				    }else if(mode == GrepMode.BEGINLINE){
				    	searchString = "^" + searchString;
				    }else if(mode == GrepMode.ENDLINE){
				    	searchString = searchString + "$";
				    }
				    scan(myFile, searchString);  
				}
			}
		}
	}
	
	/***
	 * Scan a file for a string
	 * @param file The file to scan
	 * @param searchString The string to search for
	 */
	private static void scan(File file, String searchString) {
	      // Create a Pattern object
	      Pattern pattern = Pattern.compile(searchString);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String buffer;
			int line = 1;		// Line number in the file that we are reading
			int matchCount = 0;
			while ((buffer = br.readLine()) != null) {
			      // Now create matcher object.
			      Matcher matcher = pattern.matcher((CharSequence)buffer);
			      if (matcher.find( )) {
			    	  // RegEx Match
			    	  System.out.println(file.toString() + ": line " + line + ": " + buffer);
			    	  matchCount ++;
			      } 
			      line++;
				}
			
				//Print the number of matches or that there were none.
				br.close();
				if(matchCount == 0){
					System.out.println("No matches found in " + file.toString());
				} else {
					System.out.println(matchCount + " matches found in " + file.toString());
				}
			}
			catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());	
			}
		}
	}

