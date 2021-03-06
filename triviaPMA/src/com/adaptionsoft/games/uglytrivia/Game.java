package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.Random;


import com.adaptionsoft.games.trivia.dice.Dice;
import com.adaptionsoft.games.trivia.runner.GameCards;

public class Game {
	private GameCards gameCards;
	private Dice dice;
	private Random random;
	
    ArrayList<String> players = new ArrayList<String>();
    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];
    int[] highscores= new int[6];
    
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
    
    public  Game(Random random, Dice dice){
    	gameCards = new GameCards();
    	gameCards.initialiceGameCards();
    	this.random = random;
    	this.dice = dice;
    	dice.initialice(random);
    }
    
    public boolean isAWinner(){
		if (random.nextInt(9) == 7) {
			return !wrongAnswer();
		} else {
			return !wasCorrectlyAnswered();
		}
    }

	public boolean addPlayer(String playerName) {		
	    players.add(playerName);
	    places[howManyPlayers()] = 0;
	    purses[howManyPlayers()] = 0;
	    inPenaltyBox[howManyPlayers()] = false;    
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + players.size());
		return true;
	}
	
	public int howManyPlayers() {
		return players.size();
	}

	public void roll() {
		int roll = 0;
		System.out.println(players.get(currentPlayer) + " is the current player");
		dice.roll();
		System.out.println("They have rolled a " + roll);
		
		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				
				System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
				places[currentPlayer] = places[currentPlayer] + roll;
				if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
				
				System.out.println(players.get(currentPlayer) 
						+ "'s new location is " 
						+ places[currentPlayer]);
				System.out.println("The category is " + currentCategory());
				askQuestion();
			} else {
				System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}
			
		} else {
		
			places[currentPlayer] = places[currentPlayer] + roll;
			if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
			
			System.out.println(players.get(currentPlayer) 
					+ "'s new location is " 
					+ places[currentPlayer]);
			System.out.println("The category is " + currentCategory());
			askQuestion();
		}
		
	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			gameCards.askQuestion(GameCards.POP_CATEGORY);
		if (currentCategory() == "Science")
			gameCards.askQuestion(GameCards.SCIENCE_CATEGORY);
		if (currentCategory() == "Sports")
			gameCards.askQuestion(GameCards.SPORT_CATEGORY);
		if (currentCategory() == "Rock")
			gameCards.askQuestion(GameCards.ROCK_CATEGORY);	
	}

	private String currentCategory() {
		if (places[currentPlayer] == 0) return "Pop";
		if (places[currentPlayer] == 4) return "Pop";
		if (places[currentPlayer] == 8) return "Pop";
		if (places[currentPlayer] == 1) return "Science";
		if (places[currentPlayer] == 5) return "Science";
		if (places[currentPlayer] == 9) return "Science";
		if (places[currentPlayer] == 2) return "Sports";
		if (places[currentPlayer] == 6) return "Sports";
		if (places[currentPlayer] == 10) return "Sports";
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		boolean winner = false;
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				purses[currentPlayer]++;
				System.out.println(players.get(currentPlayer) 
						+ " now has "
						+ purses[currentPlayer]
						+ " Gold Coins.");
				
				winner = didPlayerWin();
			} else {
				winner = true;
			}
			
		} else {
		
			System.out.println("Answer was correct!!!!");
			purses[currentPlayer]++;
			System.out.println(players.get(currentPlayer) 
					+ " now has "
					+ purses[currentPlayer]
					+ " Gold Coins.");
			
			winner = didPlayerWin();
		}
		nextPlayer();
		return winner;
	}
	
	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(players.get(currentPlayer)+ " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;
		
		nextPlayer();
		return true;
	}

	public void nextPlayer() {
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
	}
	
	/**
	 * Tells if the last player won.
	 */
	private boolean didPlayerWin() {
		return !(purses[currentPlayer] == 6);
	}
}
