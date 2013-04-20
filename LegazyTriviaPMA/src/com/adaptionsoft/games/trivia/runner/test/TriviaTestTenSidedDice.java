package com.adaptionsoft.games.trivia.runner.test;
import java.io.PrintStream;
import java.util.Random;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.adaptionsoft.games.trivia.dice.SingleDice;
import com.adaptionsoft.games.trivia.dice.TenSidedDice;
import com.adaptionsoft.games.trivia.runner.GameRunner;
import com.adaptionsoft.games.uglytrivia.Game;

public class TriviaTestTenSidedDice extends AbstractTriviaTest{

	@Before
	public void setUp(){
		checker = new Checker();
	}
	
	@Test
	public void outputStreamTenSidedDice() {
		System.setOut(new PrintStream(checker));
		Random rand = new Random(0L);
		Game game = GameRunner.initialize(rand, new TenSidedDice());
		GameRunner.run(game, rand);
		Assert.assertEquals(590124755L, checker.checksum.getValue());
		
	}

}
