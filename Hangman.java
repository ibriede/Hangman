package FinalProject;

/* Hangman.java - Class which hides the word and comparing guessed letters
through the loops. 
 */

import java.util.Scanner;

public class Hangman {
	//declaring variables of this class
	
	private String word, expandedWord;
	private int live, gamePlayed, won, lost;
	private char c;
	private StringBuffer hiddenWord;
	
	public Hangman() {
		gamePlayed = 0;
		won = 0;
		lost = 0;
		c = ' ';
	}
	
	/* Method which hides the word under "*" initializes expandedWord with the same word + spaces between each letter. 
	 trim() method was used to remove leading and trailing white spaces which occurs when inserting spaces between letters.
	 */
	
	public void hideWord(String word) {
		this.word = word;
		hiddenWord = new StringBuffer();
		for (int i = 0; i < word.length(); i++) {
			hiddenWord.append("* "); //with space to make it look nicer
			expandedWord = word.replace( "", " ").trim();
					
		}
	}
	
	/* Method which is re-used during the program run: it oncludes real-time statistics output and letter input
	 request and initialization.
	 */
	
	//passing the variable into method
	
	private void progress (Scanner input, StringBuffer hiddenWord, StringBuffer lettersUsed) {
		System.out.println();
		System.out.println("Lives: " + live);
		System.out.println("Word: " + hiddenWord);
		System.out.println("Used letter: " + lettersUsed);
		System.out.println("Guess a letter: ");
		
		c = input.next().charAt(0);
		c = Character.toLowerCase(c); //to get all letters be lowered
		
		if (!(Character.isLetter(c))) {    //checking if character is a letter with isLetter method
			System.out.println("\n-Invalid character was entered-");
			progress (input, hiddenWord, lettersUsed);  //calling "progress" method recursively
		}
	}
	
	//in guessWord method is happening most part of game process.
	
	public void guessWord() {
		StringBuffer lettersUsed = new StringBuffer();
		Scanner input = new Scanner(System.in);
		
		//declaring variables for this method.
		int noComa = 0;
		live = 6;
		boolean compare;
		
		//"while" loop is running while "live" is more then 0.
		//After each loop live decreases by 1.
		while (live> 0) {
			int i = 0; //this variable is used in comparison loops
			boolean stillAlive = false;
			
		//compares if hiddenWord is equal to expandedWord
			compare = (!(hiddenWord.toString().trim().equals(expandedWord.trim())));
			
		if (compare == true) {
			//calling "progress" method and passing input, hiddenWord and letterUsed into it 
			progress(input, hiddenWord, lettersUsed);
			
			String chars = lettersUsed.toString(); //converting StringBuffer to String
			
			//converting String to charArray
			char charArray[] = chars.toCharArray(); 
			while (i<charArray.length) {
				if(c == charArray[i]) {
					System.out.println("\nYou have already used: " +c);
					//calling "progress" method
					progress(input, hiddenWord, lettersUsed);
					i = -1;
				}
			i++;
		}
			
	//"if" statement which checks if this first letter or not and appends ", " to "lettersUsed".
			if(noComa == 0) {
				lettersUsed.append(c);
				noComa = 1;
			}else {
				lettersUsed.append(", " +c);
		}
			

/*"for" loop with "if" statement which traverses "expandedWord" and if letter user inputted is equal to any of the letters 
 in "expandedWord" this letter is set in its corresponding position.
 */

		for (i = 0; i<expandedWord.length(); i++){
			char k = expandedWord.charAt(i);
			if(k == c) {
				hiddenWord.setCharAt(i, c); //replaces character at a specific position of String
				stillAlive = true;
			}
		}
	if(! stillAlive) {
		live --;
	}
	
//output inside this "else"statement is printed in case if hiddenWord is equal to expandedWord.
		} else { 
			System.out.println("\nWord: " +hiddenWord + "\n");
			System.out.println("Congtratulations! You guessed the word!");
			won ++;
			break;
		}//else
		}//while(live> 0)
	//output inside this "if" statement is printed in case if hiddenWord isn1t equal to expandedWord after no lives
	if (!(hiddenWord.toString().trim().contentEquals(expandedWord.trim()))) {
		System.out.println("\nSorry, you lost this game!");
		System.out.println("\nCorrect word was: " + word);
		lost++;
	}
	gamePlayed++;
}
	//get methods
	public int getLost() {
		return lost;
	}
	public int getWon() {
		return won;
	}
	public int getGames() {
		return gamePlayed;
	}
	
}
		
	
	