/************************************************
 * grep utility
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 * edited by Kiefer Cunningham
 * cunninkf@mail.uc.edu
 * due 04/19/18
 * computer programming 2 section 2
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
 *@param filw path the directory to begin searching in . it cannot be a single file must ve a directory 
 *@param search string 
 *
 */
//processes the files and directories in the file path  passes the file paths that are given to it 
public class Grep {
	public static void grep(String filePath, String searchString, boolean recurse,String Either,boolean TwoOrMore) throws IOException {
		Path myPath = Paths.get(filePath);
		try (Stream<Path> entries = Files.list(myPath)) {
			List<Path> paths = entries.collect(Collectors.toList());
			for (Path path : paths) {
				//System.out.print(path.toString());
				File myFile = new File(path.toString());
				if (myFile.isDirectory()) {
				    //System.out.println("  It's a directory");
					if (recurse) {
						grep(myFile.toString(), searchString, true, Either, TwoOrMore);
					}
				} else {
				    //System.out.println("  It's a file");
				    scan(myFile, searchString);  
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
	// does the grepping matches file paths 
	private static void scan(File file, String searchString) {
	      // Create a Pattern object
	      Pattern pattern = Pattern.compile(searchString);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String buffer;
			int line = 1;		// Line number in the file that we are reading
			while ((buffer = br.readLine()) != null) {
			      // Now create matcher object.
			      Matcher matcher = pattern.matcher((CharSequence)buffer);
			      if (matcher.find()) {
			    	  // RegEx Match
			    	  System.out.println(file.toString() + ": " + line + ": " + buffer);// + " => " + m.group(0));
			    	  
			      } else {
			    	 //System.out.println("No Match");
			      }
				if (buffer.contains(searchString)) {
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
		
