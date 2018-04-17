/**
 * Assignment 09
 * @author Stephen Meckstroth
 * Description: An assignment to learn regex and implement grep commands using java
 * Due Date: Apr 17, 2018
 * Course: IT2045 Section 001
 * email: meckstss@mail.uc.edu
 * Citations: https://stackoverflow.com/questions/7569335/reverse-a-string-in-java
 * https://stackoverflow.com/questions/7459263/regex-whole-word
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
 *
 */
public class Grep {
	public static void grep(String filePath, String searchString, boolean recurse, boolean matchCase, boolean invertMatch, boolean matchWholeWord) throws IOException {
		Path myPath = Paths.get(filePath);
		try (Stream<Path> entries = Files.list(myPath)) {
			List<Path> paths = entries.collect(Collectors.toList());
			for (Path path : paths) {
				//System.out.print(path.toString());
				File myFile = new File(path.toString());
				if (myFile.isDirectory()) {
				    //System.out.println("  It's a directory");
					if (recurse) {
						grep(myFile.toString(), searchString, true, matchCase, invertMatch, matchWholeWord);
					}
				} else {
				    //System.out.println("  It's a file");
				    scan(myFile, searchString, matchCase, invertMatch, matchWholeWord);  
				}
				//System.out.println(path.toString() + ", " + path.getFileName() + ", " + path.getName(0) + ", " + path.getClass().toString());
			}
			//System.out.println(paths.toString());
		}
	}
	/***
	 * Scan a file for a string
	 * @param file The file to scan
	 * @param searchString The string to search for
	 */
	private static void scan(File file, String searchString, boolean matchCase, boolean invertMatch, boolean matchWholeWord) {
	      // Create a Pattern object
		Pattern pattern = null;
	      if (matchCase) {
	    	  //If matchCase is true then the match is case sensitive, no changes to searchString
	    	  
	      } else {
	    	  //If matchCase if false then convert to uppercase to make case insensitve
	    	  searchString = searchString.toUpperCase();
	      }
	      if (invertMatch) {
	    	  //If invertMatch is true then invert the search string
	    	  searchString = new StringBuilder(searchString).reverse().toString();
	      } else {
	    	  //no changes to searchString
	      }
	      if (matchWholeWord){
	    	  //If matchWholeWord is true then amend searchString to require the searchstring to be surrounded by whitespace
	    	  
	    	  searchString = ".*\\b" + searchString +"\\b.*";
	      } else {
	    	  //no changes to searchString
	      }
	      
	      pattern = Pattern.compile(searchString);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String buffer;
			int line = 1;		// Line number in the file that we are reading
			while ((buffer = br.readLine()) != null) {
			      // Now create matcher object.
			      Matcher matcher = null;
			      if (matchCase) {
			    	  //If matchCase = true then match is case sensitive
			    	  matcher = pattern.matcher((CharSequence)buffer);
			      } else {
			    	  //If matchCase = false then match case is insensitive
			    	  matcher = pattern.matcher((CharSequence)buffer.toUpperCase());
			      }
			      if (matcher.find( )) {
			    	  // RegEx Match
			    	  System.out.println(file.toString() + ": " + line + ": " + buffer);// + " => " + m.group(0));
			      } else {
			    	 // System.out.println("No Match");
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
	}
}
