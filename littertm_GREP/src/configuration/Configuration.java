/**
 * Name: Tiffany Litteral
 * Due Date: 04/17/2018
 * Assignment: GREP
 * Course: IT2060C/001/Spring 2018
 * Description: Add to the GREP class, created by Bill Nicholson.
 * Modify the GREP project at https://github.com/nicomp42/grep .
 * Your mods should include at least three options to change the behavior of GREP. 
 * Look up GREP online to see what options are implemented in different versions of the utility. 
 * Hint: "ignore case" is an easy one.
 * 
 */
package configuration;



/**
 * This is a class that configures three attributes to use with the grep method in the Grep class.
 * The filepath, searchString, and recurse allows the user to enter the path of the file(filePath) of their choosing, 
 * the string of the regular expression they are looking for(searchString) and weather or not it should recurse(recurse). 
 * @author littertm
 *
 */
public class Configuration {

	private String filePath;
	private String searchString;
	private boolean recurse;
	
	/**
	 * The Configuration uses the filepath, search string and recurse attributes and sets them through a constructor.
	 * @param filePath = Path of the file of user's choosing.
	 * @param searchString = the regular expression that the user is searching for.
	 * @param recurse = whether or not it should recurse.
	 */
	
	// Use the constructor to set  filePath, searchString, and recurse methods.
	public Configuration(String filePath, String searchString, boolean recurse ){
		this.recurse = recurse;
		this.searchString = searchString;
		this.filePath = filePath;
	}

	/**
	 * Get the filepath 
	 * @return filePath 
	 */
	
	public String getFilePath() {
		return filePath;
	}
	/**
	 * Get the searchString
	 * @return searchString
	 */

	public String getSearchString() {
		return searchString;
	}
	/**
	 * Get recurse
	 * @return recurse
	 */

	public boolean recurse() {
		return recurse;
	}

	
}
