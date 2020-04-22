package FinalProject;

/* HangmanWords.java - Class which stores database of words
 and provide random word on get method.
 */

public class HangmanWords {
	//initializing array of words
	private String wordsArray[] = {"school", "legislation", "persistance", "dance", "nature", "holidays", 
			"impressions", "programming", "implementation", "computer", "science", "museum"};
	private double index;
	
	public HangmanWords() {
	}
	//get method
	
	public String getWord() {
		//initializing "index" with random number from 0 to 12.
		index = Math.random()*12;
		//initializing "i" with a random number of "index" converted to integer.
		int i = (int) index;
		return wordsArray[i];


	}

}
