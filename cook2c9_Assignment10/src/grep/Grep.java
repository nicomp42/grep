/************************************************
 * grep utility
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 * 
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
	public static void grep(String filePath, String searchString, boolean recurse) throws IOException {
		Path myPath = Paths.get(filePath);
		try (Stream<Path> entries = Files.list(myPath)) {
			List<Path> paths = entries.collect(Collectors.toList());
			for (Path path : paths) {
				//SSystem.out.print(path.toString());
				File myFile = new File(path.toString());
				if (myFile.isDirectory()) {
				    //System.out.println("  It's a directory");
					if (recurse) {
						grep(myFile.toString(), searchString, true);
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
			      if (matcher.find( )) {
			    	  // RegEx Match
			    	  //System.out.println(file.toString() + ": " + line + ": " + buffer);// + " => " + m.group(0));
			      } else {
			    	 // System.out.println("No Match");
			      }
				if (buffer.contains(searchString) ) {
					//System.out.println(file.toString() + ": " + line + ": " + buffer);
				}
				
				
				/*
				 * Name: Connor Cook
				 * Assignment: Assignment10
				 * Description: 
				 * This class was originally created by Bill Nicholson, it demonstrates the ability to 
				 * search through a given filepath, and replace one String with Another 
				 * 
				 * 
				 * The following statements search the given file for anything that matches the searchString of a given name (in the case of this file)
				 * For a name such as "William," the name will be changed in the console to "Will" and the same with any other chosen name. 
				 */
				if(searchString.equals("William")) {						//Searches the file for anything matching the name "William"
					String willString = buffer.replace("William", "Will");	//Creates a new string and replaces the buffer in the output String with "Will" 
					System.out.println(willString);							//Prints the new string
				}
				
				if(searchString.equals("Joshua")) {							//Searches the file for anything matching the name "Joshua"
					String joshString = buffer.replace("Joshua", "Josh");	//Creates a new string and replaces the buffer in the output String with "Josh"
					System.out.println(joshString);							//Prints the new string
				}	
				
				if(searchString.equals("Johnathan")) {						//Searches the file for anything matching the name "Johnathan"
					String johnString = buffer.replace("Johnathan", "John");//Creates a new string and replaces the buffer in the output String with "John"
					System.out.println(johnString);							//Prints the new string
				}
				
				
				
				
				
				line++;
			}
			br.close();
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}	
	}
}
