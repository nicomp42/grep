/*
Edited By:
Name: Alex Hargett
Class Number and Section: Programming 2 (002)
Assignment #: 10
Due date: 4/18/2018
Description: Add three features to our grep file checker
*/
/**
 * Grep Utility Edit
 * @author hargetaj
 * Edited to include three additional features to grep's functionality
 */
package grep;

public class GrepConfig {
	private String filePath;
	private String searchString;
	private boolean recurse;
	private boolean caseInsensitive;
	private boolean previous;
	private boolean next;
	
	/**
	 * This constructor will be used to utilize our grep system
	 * @param filePath- This stores the filepath to the locations of our text documents
	 * @param searchString- The word that we will be searching for
	 * @param recurse- Determines if will recurse through the file or not
	 * @param caseInsensitive- The user will input if they want the search to detect case or not(true means you want insensitivity)
	 * @param previous- determines if the user wants to display entries prior to the one found(true allows you to see the prior entries)
	 * @param next- determines if the user wants the display the line following the found search object(true allows the next entry to be seen)
	 */
	public GrepConfig(String filePath, String searchString, boolean recurse, boolean caseInsensitive, 
			boolean previous, boolean next) {
		//A bunch of sets to adjust the values in the constructors accordingly
		setFilePath(filePath);//sets the file path
		setSearchString(searchString);//sets the string we are searching for
		setRecurse(recurse);//sets if we shall recurse through the file
		setCaseInsensitive(caseInsensitive);//sets if case matters in our search
		setPrevious(previous);//sets if you want to see item prior on the list
		setNext(next);//sets if you want to see the next item on the list
	}
	
	//Getter and setters to for the arguments above
	/**
	 * @return- Getter to retrieve values later
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * setter to establish new values for our file path
	 * @param filePath- the path which the files are stored
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * @return- Getter to retrieve values later
	 */
	public String getSearchString() {
		return searchString;
	}
	/**
	 * setter to establish new values for our searchString
	 * @param searchString- the word or phrase that we look for
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	/**
	 * @return- Getter(is for boolean) to retrieve values later
	 */
	public boolean isRecurse() {
		return recurse;
	}
	/**
	 * setter to establish new values for our file path
	 * @param recurse- true or false weather we recurse through files
	 */
	public void setRecurse(boolean recurse) {
		this.recurse = recurse;
	}
	/**
	 * @return- Getter(is for boolean) to retrieve values later
	 */
	public boolean isCaseInsensitive() {
		return caseInsensitive;
	}
	/**
	 * setter to establish new values for our file path
	 * @param caseInsensitive- if true the search wont be cap discriminate
	 */
	public void setCaseInsensitive(boolean caseInsensitive) {
		this.caseInsensitive = caseInsensitive;
	}
	/**
	 * @return- Getter(is for boolean) to retrieve values later
	 */
	public boolean isPrevious() {
		return previous;
	}
	/**
	 * setter to establish new values for our file path
	 * @param previous- true if you want line before the result
	 */
	public void setPrevious(boolean previous) {
		this.previous = previous;
	}
	/**
	 * @return- Getter(is for boolean) to retrieve values later
	 */
	public boolean isNext() {
		return next;
	}
	/**
	 * setter to establish new values for our file path
	 * @param next- true if you want the line after the result
	 */
	public void setNext(boolean next) {
		this.next = next;
	}
}
