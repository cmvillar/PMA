package com.adaptionsoft.games.trivia.runner.test;
import java.io.PrintStream;
import java.util.Random;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.adaptionsoft.games.trivia.dice.SingleDice;
import com.adaptionsoft.games.trivia.outputdevice.ConsoleDevice;
import com.adaptionsoft.games.trivia.runner.GameRunner;
import com.adaptionsoft.games.uglytrivia.Game;

public class TriviaTestSixPlayers extends AbstractTriviaTest{

	@Before
	public void setUp(){
		checker = new Checker();
	}
	
	@Test
	public void outputStreamSixPlayers() {
		System.setOut(new PrintStream(checker));
		Random rand = new Random(0L);
		Game game = GameRunner.initializeSixPlayers(rand, new SingleDice(), new ConsoleDevice());
		GameRunner.run(game, rand);
		Assert.assertEquals(1031644807L, checker.checksum.getValue());
		
	}

}
