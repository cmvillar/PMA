
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private boolean notAWinner;

	public void main(String[] args) {
		Game theGame = initialize();
		Random rand = new Random();
		run(theGame,rand);
		
	}
	
	public void run(Game aGame, Random rand) {
		do {
			
			aGame.roll(rand.nextInt(5) + 1);
			
			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}
			
		} while (notAWinner);
	}
	
	public Game initialize() {
		Game aGame = new Game();
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");
		return aGame;
	}
}
