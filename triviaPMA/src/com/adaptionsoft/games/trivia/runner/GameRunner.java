
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		Game aGame = initialize();
		Random rand = new Random();
		run(aGame,rand);
		
	}
	
	public static void run(Game aGame, Random rand) {
		do {
			
			aGame.roll(rand.nextInt(5) + 1);
			
			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}
			
		} while (notAWinner);
	}
	
	public static Game initialize() {
		Game aGame = new Game();
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");
		return aGame;
	}
}