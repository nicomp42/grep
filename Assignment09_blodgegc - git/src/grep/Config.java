/***
 * Name: Greg Blodgett
 * Assignment number: 
 * Course #, and section: Course 2045, Section 1
 * Due date: 
 * Description: The config class that stores the configurations for the grep search.
 * Citations: 
 * Stack overflow user TomC (https://stackoverflow.com/questions/163360/regular-expression-to-match-urls-in-java)
 * Anything else:
 */

package grep;

/***
 * Config settings for calling grep
 * pass a config object to the grep method
 * http://www.regexlib.com/DisplayPatterns.aspx
 * @author blodgegc
 *
 */

public class Config {
	/** 
	 * A constructor that simply sets the filePath
	 * @param filePath The files to be searched.
	 */
	public Config(String filePath) {
		setFilePath(filePath);
		
	}
	private String filePath;
	
	private String searchString;
	/**
	 * Retrieves the filePath
	 * @return filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * Defines the filePath
	 * @param filePath The path to be searched
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * Retrieves the searchString
	 * @return searchString
	 */
	public String getSearchString() {
		return searchString;
	}
	/**
	 * Defines the searchString
	 * @param searchString The string to search for
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	/**
	 * A modified toString method 
	 * @return filePath and searchString
	 */
	public String toString() {
		return this.getFilePath() + " : " + this.getSearchString();
	}
	


}
