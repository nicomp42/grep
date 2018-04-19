/************************************************
 * grep utility
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 * 
 * Modified by Tucker Godsey
 * 
 * This class uses Grep to search for words in multiple files
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

/***
 * Grep Utility
 * @author nicomp
 * Modified by Tucker Godsey
 * Processes the files
 */
public class Grep {
	
	/**
	 * 
	 * @param config - Configuration used for the search
	 * @return String full of words found by the search
	 */
	public static String grep(Config config) throws IOException { // Previously String filePath, String searchString, boolean recurse
		String foundWords = ""; //Stores all found worlds
		
		Path myPath = Paths.get(config.getFilePath());
		try (Stream<Path> entries = Files.list(myPath)) {
			List<Path> paths = entries.collect(Collectors.toList());
			for (Path path : paths) {
				//System.out.print(path.toString());
				File myFile = new File(path.toString());
				if (myFile.isDirectory()) {
				    //System.out.println("  It's a directory");
					if (config.isRecurse()) {
						grep(config);
					}
				} else {
				    //System.out.println("  It's a file");
				    foundWords += scan(myFile, config.getSearchString(), config);
				    
				}
				//System.out.println(path.toString() + ", " + path.getFileName() + ", " + path.getName(0) + ", " + path.getClass().toString());
			}
			//System.out.println(paths.toString());
		}
		System.out.println("Returning " + foundWords);
		return foundWords;
	}
	/***
	 * Scan a file for a string in a single file.
	 * @param file The file to scan
	 * @param searchString The string to search for, can be a regular expression
	 */
	private static String scan(File file, String searchString, Config config) {
	    String foundWords = ""; // Stores all founds words
		
		// If the user only wants to search for the begining of the string, add the expression to do so
		if (config.isBeginningOfString() == true) {
			searchString = "^" + searchString;
		}
		
		
		// If the user only wants to search for the end of the string, add the expression to do so
		if (config.isEndOfString() == true) {
			searchString = searchString + "$";
		}
		
		// Create a Pattern object
	      Pattern pattern = Pattern.compile(searchString);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String buffer;
			int line = 1;		// Line number in the file that we are reading
			
			// If the user does not want to search with case sensitivity, recompile the Pattern object with case sensitivity off
			if (config.isCaseSensitive() == false) {
				pattern = Pattern.compile(searchString, Pattern.CASE_INSENSITIVE);
			}
			
			while ((buffer = br.readLine()) != null) {
			      // Now create matcher object.
			      Matcher matcher = pattern.matcher((CharSequence)buffer);
			      if (matcher.find( )) {
			    	  // RegEx Match
			    	  // System.out.println(file.toString() + ": " + line + ": " + buffer);
			    	  if (!buffer.equals(null) && !buffer.equals("")) {
			    		  foundWords += buffer;
			    	  }
			      } else {
			    	 //System.out.println("No Match");
			      }
				if (buffer.contains(searchString) ) {
					//System.out.println(file.toString() + ": " + line + ": " + buffer);
				}
				line++;
			}
			br.close();
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		return foundWords;
	}
}
