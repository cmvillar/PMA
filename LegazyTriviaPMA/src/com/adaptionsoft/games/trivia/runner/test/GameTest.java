package com.adaptionsoft.games.trivia.runner.test;

import java.util.ArrayList;
import java.util.Random;

import junit.framework.Assert;

import org.junit.Test;

import com.adaptionsoft.games.trivia.dice.SingleDice;
import com.adaptionsoft.games.trivia.outputdevice.ConsoleDevice;
import com.adaptionsoft.games.trivia.outputdevice.OutputDevice;
import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Player;


public class GameTest {
	@Test
	public void addPlayer() {
		Random random = new Random();
		OutputDevice outputDevice = new ConsoleDevice();
		Game aGame = new Game(random, new SingleDice(), outputDevice);
		aGame.addPLayer("Chet");
		ArrayList<Player> expectedResult = new ArrayList<Player>();
		expectedResult.add(new Player("Chet"));
		Assert.assertEquals(expectedResult, aGame.getPlayers());
	}
	
	@Test
	public void addSixthPlayer() {
		Random random = new Random();
		OutputDevice outputDevice = new ConsoleDevice();
		Game aGame = new Game(random, new SingleDice(), outputDevice);
		aGame.addPLayer("Chet");
		aGame.addPLayer("Chet2");
		aGame.addPLayer("Chet3");
		aGame.addPLayer("Chet4");
		aGame.addPLayer("Chet5");
		aGame.addPLayer("Chet6");
		ArrayList<Player> expectedResult = new ArrayList<Player>();
		expectedResult.add(new Player("Chet"));
		expectedResult.add(new Player("Chet2"));
		expectedResult.add(new Player("Chet3"));
		expectedResult.add(new Player("Chet4"));
		expectedResult.add(new Player("Chet5"));
		expectedResult.add(new Player("Chet6"));
		Assert.assertEquals(expectedResult, aGame.getPlayers());
	}
	
	public void removePlayerFromEmptyList(){
		Assert.fail();
	}
}
