package com.adaptionsoft.games.trivia.test;

import junit.framework.Assert;

import org.junit.Test;

import com.adaptionsoft.games.trivia.runner.GameCards;


public class GameCardsTest extends AbstractTriviaTest{
	public GameCardsTest(){
		super();
	}
	
	@Test
	public void askPopQuestion() {
		GameCards gameCards = new GameCards();
		gameCards.initialiceGameCards();
		gameCards.askQuestion(GameCards.POP_CATEGORY);
		Assert.assertEquals(1763398543L, checker.checksum.getValue());
	}

}
