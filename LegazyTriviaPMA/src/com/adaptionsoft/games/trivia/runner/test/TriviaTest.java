package com.adaptionsoft.games.trivia.runner.test;
import java.io.PrintStream;
import java.util.Random;


import junit.framework.Assert;

import org.junit.Test;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import com.adaptionsoft.games.uglytrivia.Game;

public class TriviaTest extends AbstractTriviaTest{

	
	@Test
	public void test() {
		Checker checker = new Checker();
		System.setOut(new PrintStream(checker));
		Random rand = new Random(0L);
		Game game = GameRunner.initialize();
		GameRunner.run(game, rand);
		Assert.assertEquals(590124755L, checker.checksum.getValue());
		
	}

}
