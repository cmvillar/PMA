package com.adaptionsoft.games.trivia.runner.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.adaptionsoft.games.trivia.runner.GameCards;


public class GameCardsTest extends AbstractTriviaTest{
	public GameCardsTest(){
		super();
	}
	
	@Before
	public void setUp(){
		checker = new Checker();
	}
	
	@Test
	public void askPopQuestion() {
		GameCards gameCards = new GameCards();
		gameCards.initialiceGameCards();
		gameCards.askQuestion(GameCards.POP_CATEGORY);
		Assert.assertEquals(0L, checker.checksum.getValue());
	}
	
	@Test
	public void askRockQuestion() {
		GameCards gameCards = new GameCards();
		gameCards.initialiceGameCards();
		gameCards.askQuestion(GameCards.ROCK_CATEGORY);
		Assert.assertEquals(0L, checker.checksum.getValue());
	}

	@Test
	public void askScienceQuestion() {
		GameCards gameCards = new GameCards();
		gameCards.initialiceGameCards();
		gameCards.askQuestion(GameCards.SCIENCE_CATEGORY);
		Assert.assertEquals(0L, checker.checksum.getValue());
	}
	
	@Test
	public void askSportQuestion() {
		GameCards gameCards = new GameCards();
		gameCards.initialiceGameCards();
		gameCards.askQuestion(GameCards.SPORT_CATEGORY);
		Assert.assertEquals(0L, checker.checksum.getValue());
	}


}
