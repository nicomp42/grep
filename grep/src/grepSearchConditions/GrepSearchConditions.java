/*****************************************************
 *Name: Ben Tenhover
 *Assignment: Assignment 10
 *Due Date: 4/19/2018
 *Course/Section/Semester: 2045C/002/Spring 2018
 *Email: tenhovbe@mail.uc.edu
 *Citations: StackOverFlow.com, regexlib.com, in-class work, textbook
 *Description: Modify the grep project to change the behavior of grep at least 3 different ways
 */

package grepSearchConditions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import grep.Grep;

/**
 * Modifies the search conditions while searching through a directory of files
 * @author Ben Tenhover
 */
public class GrepSearchConditions {

	/**
	 * Processes the files and directories in the filePath string ignoring case sensitivity
	 * @param filePath the directory to begin searching in. It cannot be a single file, must be a directory
	 * @param searchString The regular expression to match
	 * @param recurse If true, delve into any subdirectory to find match
	 */
	public static void grepCaseInsensitive(String filePath, String searchString, boolean recurse) throws IOException { // Add other class ex. Config config
		Path myPath = Paths.get(filePath);
		try (Stream<Path> entries = Files.list(myPath)) {
			List<Path> paths = entries.collect(Collectors.toList());
			for (Path path : paths) {
				//System.out.print(path.toString());
				File myFile = new File(path.toString());
				if (myFile.isDirectory()) {
					//System.out.println("  It's a directory");
					if (recurse) {
						grepCaseInsensitive(myFile.toString(), searchString, true);
					}
				} else {
					//System.out.println("  It's a file");
					scanCaseInsensitive(myFile, searchString);  
				}
				//System.out.println(path.toString() + ", " + path.getFileName() + ", " + path.getName(0) + ", " + path.getClass().toString());
			}
			//System.out.println(paths.toString());
		}
	}

	/**
	 * Scan a file for a string, ignoring case sensitivity
	 * @param file The file to scan
	 * @param searchString The string to search for, can be a regular expression
	 */
	private static void scanCaseInsensitive(File file, String searchString) {
		// Create a Pattern object
		Pattern pattern = Pattern.compile(searchString, Pattern.CASE_INSENSITIVE); // This enables case insensitive matching
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
	/**
	 * Processes the files and directories in the filePath string
	 * @param filePath the directory to begin searching in. It cannot be a single file, must be a directory
	 * @param searchString The regular expression to match
	 * @param recurse If true, delve into any subdirectory to find match
	 */
	public static void grepInverseCaseSensitive(String filePath, String searchString, boolean recurse) throws IOException { // Add other class ex. Config config
		Path myPath = Paths.get(filePath);
		try (Stream<Path> entries = Files.list(myPath)) {
			List<Path> paths = entries.collect(Collectors.toList());
			for (Path path : paths) {
				//System.out.print(path.toString());
				File myFile = new File(path.toString());
				if (myFile.isDirectory()) {
					//System.out.println("  It's a directory");
					if (recurse) {
						grepInverseCaseSensitive(myFile.toString(), searchString, true);

					}
				} else {
					//System.out.println("  It's a file");
					scanInverseCaseSensitive(myFile, searchString);  
				}
				//System.out.println(path.toString() + ", " + path.getFileName() + ", " + path.getName(0) + ", " + path.getClass().toString());
			}
			//System.out.println(paths.toString());
		}
	}

	/***
	 * Scan a file for all strings that don't contain the specified sequence or pattern with case sensitivity
	 * @param file The file to scan
	 * @param searchString The string to search for, can be a regular expression
	 */
	private static void scanInverseCaseSensitive(File file, String searchString) {
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
				} else {
					System.out.println(file.toString() + ": " + line + ": " + buffer); // If the sequence isn't found, print results
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

	/**
	 * Processes the files and directories in the filePath string
	 * @param filePath the directory to begin searching in. It cannot be a single file, must be a directory
	 * @param searchString The regular expression to match
	 * @param recurse If true, delve into any subdirectory to find match
	 */
	public static void grepInverseCaseInsensitive(String filePath, String searchString, boolean recurse) throws IOException { // Add other class ex. Config config
		Path myPath = Paths.get(filePath);
		try (Stream<Path> entries = Files.list(myPath)) {
			List<Path> paths = entries.collect(Collectors.toList());
			for (Path path : paths) {
				//System.out.print(path.toString());
				File myFile = new File(path.toString());
				if (myFile.isDirectory()) {
					//System.out.println("  It's a directory");
					if (recurse) {
						grepInverseCaseInsensitive(myFile.toString(), searchString, true);

					}
				} else {
					//System.out.println("  It's a file");
					scanInverseCaseInsensitive(myFile, searchString);  
				}
				//System.out.println(path.toString() + ", " + path.getFileName() + ", " + path.getName(0) + ", " + path.getClass().toString());
			}
			//System.out.println(paths.toString());
		}
	}

	/**
	 * Scan a file for all strings that don't contain the specified sequence or pattern without case sensitivity
	 * @param file The file to scan
	 * @param searchString The string to search for, can be a regular expression
	 */
	private static void scanInverseCaseInsensitive(File file, String searchString) {
		// Create a Pattern object
		Pattern pattern = Pattern.compile(searchString, Pattern.CASE_INSENSITIVE); // This enables case insensitive matching
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
				} else {
					System.out.println(file.toString() + ": " + line + ": " + buffer); // If the sequence isn't found, print results
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

	/**
	 * Processes the files and directories in the filePath string
	 * @param filePath the directory to begin searching in. It cannot be a single file, must be a directory
	 * @param searchString The regular expression to match
	 * @param recurse If true, delve into any subdirectory to find match
	 */
	public static void grepFileName(String filePath, String searchString, boolean recurse) throws IOException { 
		Path myPath = Paths.get(filePath);
		try (Stream<Path> entries = Files.list(myPath)) {
			List<Path> paths = entries.collect(Collectors.toList());
			for (Path path : paths) {
				//System.out.print(path.toString());
				File myFile = new File(path.toString());
				if (myFile.isDirectory()) {
					//System.out.println("  It's a directory");
					if (recurse) {
						grepFileName(myFile.toString(), searchString, true);

					}
				} else {
					//System.out.println("  It's a file");
					scanFileName(myFile, searchString);  
				}
				//System.out.println(path.toString() + ", " + path.getFileName() + ", " + path.getName(0) + ", " + path.getClass().toString());
			}
			//System.out.println(paths.toString());
		}
	}

	/***
	 * Scan a file for a string and return just the file and file path in which it is contained
	 * @param file The file to scan
	 * @param searchString The string to search for, can be a regular expression
	 */
	private static void scanFileName(File file, String searchString) {
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
					System.out.println(file.toString());// If match is found, print out just the file and file path it is contained in
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






