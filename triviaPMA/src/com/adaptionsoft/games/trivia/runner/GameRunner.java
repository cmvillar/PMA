
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.trivia.dice.SingleDice;
import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private static boolean notAWinner;

	public static void  main(String[] args) {
		Random rand = new Random();
		Game theGame = initialize(rand);

		run(theGame,rand);
		
	}
	
	public static void run(Game aGame, Random rand) {
		do {
			
			aGame.roll();
			
			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}
			
		} while (notAWinner);
	}
	
	public static Game initialize(Random rand) {
		Game aGame = new Game(new SingleDice(rand));
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");
	/*	aGame.add("Chet2");
		aGame.add("Pat2");
		aGame.add("Sue2");
		*/
		return aGame;
	}
}
