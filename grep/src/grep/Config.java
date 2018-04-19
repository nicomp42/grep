/**
 * Config class for configuring the Grep search
 * 
 * Written by Tucker Godsey
 */
package grep;

public class Config {
	private String filePath;
	private String searchString;
	private boolean recurse;
	private boolean isCaseSensitive;
	private boolean beginningOfString;
	private boolean endOfString;
	
	/**
	 * Constructor for the config
	 * @param filePath - File Path that is searched (NOTE: Must be the file containing the text file(s) and not the text file(s) themselves
	 * @param searchString - The string that is searched
	 * @param recurse - Include sub-folders
	 * @param isCaseSensitive - Should the search be case-sensitive?
	 * @param beginningOfString - Should the input string be the beginning of the word/string (Files are read in lines. 1 line = 1 string)
	 * @param endOfString - Should the input string be the ending of the word/string (Files are read in lines. 1 line = 1 string)
	 */
	public Config(String filePath, String searchString, boolean recurse, boolean isCaseSensitive, boolean beginningOfString, boolean endOfString) {
		setFilePath(filePath);
		setSearchString(searchString);
		setRecurse(recurse);
		setCaseSensitive(isCaseSensitive);
		setBeginningOfString(beginningOfString);
		setEndOfString(endOfString);
	}
	
	/**
	 * Reads out all the settings for the config object
	 * @return - A string full of settings, designed for readablility
	 */
	public String readConfig() {
		return "Filepath: " +  filePath + " - Keyword: " + searchString + " - Sub-Folders: " + recurse + " - Case Sensitive: " + isCaseSensitive
		+ " - Beginning of String: " + beginningOfString + " - End of String: " + endOfString;
	}
	
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * @param Sets the filepath
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * @return the searchString
	 */
	public String getSearchString() {
		return searchString;
	}
	/**
	 * @param Sets the String that is searched
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	/**
	 * @return the recurse
	 */
	public boolean isRecurse() {
		return recurse;
	}
	/**
	 * @param True / False statement for Recurse - Do you want to search sub-folders?
	 */
	public void setRecurse(boolean recurse) {
		this.recurse = recurse;
	}
	/**
	 * @return the isCaseSensitive
	 */
	public boolean isCaseSensitive() {
		return isCaseSensitive;
	}
	/**
	 * @param True / False statement for Case Sensitivity
	 */
	public void setCaseSensitive(boolean isCaseSensitive) {
		this.isCaseSensitive = isCaseSensitive;
	}


	/**
	 * @return the beginingOfString
	 */
	public boolean isBeginningOfString() {
		return beginningOfString;
	}


	/**
	 * @param True / False statement - Do you want to search for the beginning of the String in the files? (NOTE: 1 line is 1 string. Lines should each only be one word)
	 */
	public void setBeginningOfString(boolean beginningOfString) {
		this.beginningOfString = beginningOfString;
	}


	/**
	 * @return the endOfString
	 */
	public boolean isEndOfString() {
		return endOfString;
	}


	/**
	 * @param True / False statement - Do you want to search for the end of the String in the files? (NOTE: 1 line is 1 string. Lines should each only be one word)
	 */
	public void setEndOfString(boolean endOfString) {
		this.endOfString = endOfString;
	}
	
}
