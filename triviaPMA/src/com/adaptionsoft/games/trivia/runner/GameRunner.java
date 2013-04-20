
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.trivia.dice.SingleDice;
import com.adaptionsoft.games.trivia.dice.TenSidedDice;
import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private static boolean isAWinner;

	public static void  main(String[] args) {
		Random rand = new Random();
		Game theGame = initialize(rand);

		run(theGame,rand);
		
	}
	
	public static void run(Game aGame, Random rand) {
		do {			
			aGame.roll();		
		} while (!aGame.isAWinner());
	}
	
	public static Game initialize(Random rand) {
		Game aGame = new Game(rand, new TenSidedDice());
		aGame.addPlayer("Chet");
		aGame.addPlayer("Pat");
		aGame.addPlayer("Sue");
		return aGame;
	}
}
