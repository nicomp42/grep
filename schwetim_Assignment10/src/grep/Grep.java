/************************************************
 * grep utility
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
/******
 * Name: Ian Schwettman
 * Assignment: Assignment10
 * Due Date: 4/19/2018
 * Description: A Grep class that will scan the target folder for all text files inside of the folder, and return the matches it finds for the searchstring inside those text files.
 * Class Number & Section: IT2045C
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
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * Grep Utility
 * @author nicomp, schwetim
 * @param function 1 = Case Insensitive; 2 = Invert Match (returns everything that DOESN'T include the search string); 3 = Exact Match, the searchstring must be found in the filePath exactly as entered in the main.
 * @param filePath the filePath that is being searched through.
 * @param searchString the string that is being searched for.
 */
public class Grep {
	public static void grep(String filePath, String searchString, boolean recurse, int function) throws IOException 
	{
		Path myPath = Paths.get(filePath);
		try (Stream<Path> entries = Files.list(myPath)) 
		{
			List<Path> paths = entries.collect(Collectors.toList());
			for (Path path : paths) 
			{
				File myFile = new File(path.toString());
				if (myFile.isDirectory()) 
				{
					if (recurse) 
					{
						grep(myFile.toString(), searchString, true, function);
					}
				} 
				else 
				{
				    if (function == 0)
				    {
				    	scan(myFile, searchString);		// Calls the default scan method that doesn't do anything fancy.
				    }
				    else if (function == 1)
				    {
				    	scanCaseInsensitive(myFile, searchString);		// Calls the method that scans for the searchstring ignoring case.
				    } 
				    else if (function == 2)
				    {
				    	scanInvert(myFile, searchString);		// Calls the method that scans for the searchstring and prints everything else.
				    }
				    else if (function == 3)
				    {
				    	scanExact(myFile, searchString);		// Calls the method that scans for the searchstring exactly as entered.
				    }
				    else
				    {
				    	System.out.println("Please enter a valid integer of value 0-3");
				    }
				}
			}
		}
	}
	/***
	 * Scan a file for a string and print the matches, the basic grep method.
	 * @param file The file to scan
	 * @param searchString The string to search for
	 */
	private static void scan(File file, String searchString) 
	{
	      // Create a Pattern object
	      Pattern pattern = Pattern.compile(searchString);
		try 
		{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String buffer;
			int line = 1;		// Line number in the file that we are reading
			while ((buffer = br.readLine()) != null) 
			{
			      // Now create matcher object.
			      Matcher matcher = pattern.matcher((CharSequence)buffer);
			      if (matcher.find( )) 
			      {
			    	  // RegEx Match
			    	  System.out.println(file.toString() + ": " + line + ": " + buffer);
			      } 
			      else 
			      {
			    	 // System.out.println("No Match");
			      }
				if (buffer.contains(searchString) ) 
				{
					//System.out.println(file.toString() + ": " + line + ": " + buffer);
				}
				line++;
			}
			br.close();
		} 
		catch (Exception ex) 
		{
			System.out.println(ex.getLocalizedMessage());
		}
	}
	/***
	 * Scan a file for a string ignoring case and print the matches.
	 * @param file The file to scan
	 * @param searchString The string to search for
	 */
	private static void scanCaseInsensitive(File file, String searchString) 
	{
		// Create a Pattern object
	    Pattern pattern = Pattern.compile(searchString.toLowerCase());
		try 
		{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String buffer;
			int line = 1;		// Line number in the file that we are reading
			while ((buffer = br.readLine()) != null) 
			{ 
				// Now create matcher object.
			      Matcher matcher = pattern.matcher((CharSequence)buffer.toLowerCase());
			      if (matcher.find( )) 
			      {
			    	  // RegEx Match
			    	  System.out.println(file.toString() + ": " + line + ": " + buffer);
			      } 
			      else 
			      {
			    	 // System.out.println("No Match");
			      }
				if (buffer.contains(searchString) ) 
				{
					//System.out.println(file.toString() + ": " + line + ": " + buffer);
				}
				line++;
			}
			br.close();
		}
		catch (Exception ex) 
		{
			System.out.println(ex.getLocalizedMessage());
		}
	}
	/***
	 * Scan a file for a string and prints everything that doesn't include the string.
	 * @param file The file to scan
	 * @param searchString The string to search for
	 */
	private static void scanInvert(File file, String searchString) 
	{
	      // Create a Pattern object
	      Pattern pattern = Pattern.compile(searchString);
		try 
		{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String buffer;
			int line = 1;		// Line number in the file that we are reading
			while ((buffer = br.readLine()) != null) 
			{
			    Matcher matcher = pattern.matcher((CharSequence)buffer);
			    if (matcher.find()) 
			    {
			    } 
			    else 
			    {
			    	System.out.println(file.toString() + ": " + line + ": " + buffer);
			    }
				line++;
			}
			br.close();
		} 
		catch (Exception ex) 
		{
			System.out.println(ex.getLocalizedMessage());
		}
	}
	/***
	 * Scan a file for an exact string and print the matches.
	 * @param file The file to scan
	 * @param searchString The string to search for
	 */
	private static void scanExact(File file, String searchString) 
	{
		try 
		{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String buffer;
			int line = 1;		// Line number in the file that we are reading
			while ((buffer = br.readLine()) != null) 
			{
			    if (buffer.equals(searchString))
			    {
			    	System.out.println(file.toString() + ": " + line + ": " + buffer);
			    }
			}
			br.close();
		} 
		catch (Exception ex) 
		{
			System.out.println(ex.getLocalizedMessage());
		}
	}
}