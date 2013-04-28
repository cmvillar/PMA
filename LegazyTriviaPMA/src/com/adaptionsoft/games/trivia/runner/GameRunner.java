
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.trivia.dice.Dice;
import com.adaptionsoft.games.trivia.dice.SingleDice;
import com.adaptionsoft.games.trivia.outputdevice.ConsoleDevice;
import com.adaptionsoft.games.trivia.outputdevice.OutputDevice;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	public static void main(String[] args) {
		Random rand = new Random();
		OutputDevice outputDevice = new ConsoleDevice();
		Game aGame = initialize(rand,new SingleDice(), outputDevice);
		run(aGame, rand);
	}
	
	public static void run(Game aGame, Random rand) {
		do {			
			aGame.roll();		
		} while (!aGame.isAWinner());
	}
	
	public static Game initialize(Random random, Dice dice, OutputDevice outputDevice){
		Game aGame = new Game(random, dice, outputDevice);
		
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");
		
		return aGame;
		
	}
	
	public static Game initializeSixPlayers(Random random, Dice dice, OutputDevice outputDevice){
		Game aGame = new Game(random, dice, outputDevice);
		
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");
		aGame.add("John");
		aGame.add("Moon");
		aGame.add("Boris");
		
		return aGame;
		
	}
}
