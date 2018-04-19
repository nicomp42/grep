/***************************************
  * Regular Expressions and grep
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 * edited by Kiefer Cunningham
 * cunninkf@mail.uc.edu
 * due 04/19/18
 * computer programming 2 section 2
 */
package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import grep.Grep;
public class Main {
	public static void main(String[] args) {
		
		regularExpressionDemo();
		
		try {
			Grep.grep("c:\\users\\cunnikf\\test\\", "dodge*", true, null, false);
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
	/***
	 * Demo the Regular Expression syntax
	 */
	private static void regularExpressionDemo() {
		  System.out.println("Regular Expression Demos...");
	      Pattern pattern = Pattern.compile("fish", Pattern.CASE_INSENSITIVE);
	      Matcher matcher = pattern.matcher((CharSequence)"The Fish swims");
	      if (matcher.find( )) {
	    	  System.out.println("Match found:" + matcher.group(0));
	      } else {
	    	  System.out.println("NO match found.");
	      }
	      // The expression must have fih maybe s 
	      pattern = Pattern.compile("fis?h");
	      matcher = pattern.matcher((CharSequence)"fih");
	      if (matcher.find( )) {
	    	  System.out.println("Match found:" + matcher.group(0));
	      } else {
	    	  System.out.println("NO match found.");
	      }
	     // must have at least 2 f's in the word  
	      pattern = Pattern.compile("f{2,}+");			// It's actually \d{5}
	      matcher = pattern.matcher((CharSequence)"daffy duck is doing duck things");
	      if (matcher.find( )) {
	    	  System.out.println("Match found:" + matcher.group(0));
	      } else {
	    	  System.out.println("NO match found.");
	      }
	      // The expression must have either daffy or duck 
	      pattern = Pattern.compile("(duck|daffy)"); // finds 
	      matcher = pattern.matcher((CharSequence)"daffy duck is doing duck things");
	      if (matcher.find( )) {
	    	  System.out.println("Match found:" + matcher.group(0));
	      } else {
	    	  System.out.println("NO match found.");
	      }
	}
}
