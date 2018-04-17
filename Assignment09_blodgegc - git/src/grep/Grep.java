/***
 * Name: Greg Blodgett
 * Assignment number: 
 * Course #, and section: Course 2045, Section 1
 * Due date: 4/17/18
 * Description: The grep class 
 * Citations: 
 * Stack overflow user TomC (https://stackoverflow.com/questions/163360/regular-expression-to-match-urls-in-java)
 * 
 * Anything else:
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
	 * The grep method that searches a file path for a given String
	 * @param config The object that contains the configuration of the search
	 * @throws IOException
	 */
	public static void grep(Config config) throws IOException {
		Path myPath = Paths.get(config.getFilePath());
		try (Stream<Path> entries = Files.list(myPath)) {
			List<Path> paths = entries.collect(Collectors.toList());
			for (Path path : paths) {
				//System.out.print(path.toString());
				File myFile = new File(path.toString());
				if (myFile.isDirectory()) {
				    System.out.println("  It's a directory");
				} else {
				    scan(myFile, config.getSearchString());  
				}
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
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
			boolean isFound = false;
			String buffer;
			int line = 1;		// Line number in the file that we are reading
			while ((buffer = br.readLine()) != null) {
			      // Now create matcher object.
			      Matcher matcher = pattern.matcher((CharSequence)buffer);
			      if (matcher.find( )) {
			    	  // RegEx Match
			    	  System.out.println("Match found: " + matcher.group(0));
			    	  System.out.println("At: " + file.toString() + ", Line: " + line);
			    	  isFound = true;
			      } 
				 line++;
			}
			if(isFound==false) {
				System.out.println("No match found");
			}
			br.close();
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}	
	}
}
