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
		Assert.fail();
	}
}
