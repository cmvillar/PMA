package com.adaptionsoft.games.trivia.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import com.adaptionsoft.games.uglytrivia.Game;


public class TriviaTest extends AbstractTriviaTest{

	@Before
	public void setUp(){
		checker = new Checker();
	}
	
	@Test
	public void outputStream() {
		System.setOut(new PrintStream(checker));
		Random rand = new Random(0L);
		Game game = GameRunner.initialize();
		GameRunner.run(game, rand);
		Assert.assertEquals(1763398543L, checker.checksum.getValue());
		
	}

}
