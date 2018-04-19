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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AltGrepFileReader {
/**
 * 
 * @param file- file found inside eclipse.
 * @param searchString- string to search for.
 * @throws IOException
 * @throws FileNotFoundException
 */
	public static void Alt(String file, String searchString) throws IOException,FileNotFoundException{
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
			    	 System.out.println(file.toString() + ": " + line + ": " + buffer);// + " => " + m.group(0));
			      } else {
			    	 //System.out.println("No Match");
			      }
				if (buffer.contains(searchString) ) {
					//System.out.println(file.toString() + ": " + line + ": " + buffer);
				}
			line++;}
		br.close();
	} catch (Exception ex) {
		System.out.println(ex.getLocalizedMessage());
		
}
	
}}
