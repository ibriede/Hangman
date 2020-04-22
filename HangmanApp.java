package FinalProject;

import java.util.Scanner;

/* HangmanApp.java - Main class which includes main method, input and
 statistics output.
 */
public class HangmanApp {
	public static void main(String[] args) {
		System.out.println("\nWelcome to Hangman Game!");
		//initializing variables
		String word;
		char playAgain;
		int lost, won, games;
		Scanner input = new Scanner(System.in);
		
		//declaring an object "game" of type Hangman
		Hangman game = new Hangman();
		//declaring an object "myWords" of type HangmanWords
		HangmanWords myWords = new HangmanWords();
		
		//"do while" sentinel loop which allows user to decide to continue game or not
		do {
			word = myWords.getWord();
			game.hideWord(word);
			game.guessWord();
			System.out.println("Do you wish to play again? (Y/N)");
			playAgain = input.next().charAt(0);
		}while (playAgain =='Y' || playAgain == 'y');
		
		//game statistics variables initialization
		lost = game.getLost();
		won = game.getWon();
		games = game.getGames();
		//game statistics output
		System.out.println("Game statistics: \n"
				+"Games playes: \t"+games+"\n"
				+"Games won: \t"+won+"\n"
				+ "Games lost: \t"+lost+"\n");	
	}

}
