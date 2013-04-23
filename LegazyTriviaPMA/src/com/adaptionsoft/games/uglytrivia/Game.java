package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.Random;

import com.adaptionsoft.games.trivia.dice.Dice;
import com.adaptionsoft.games.trivia.outputdevice.OutputDevice;
import com.adaptionsoft.games.trivia.runner.GameCards;


public class Game {
	private GameCards gameCards;
	private Random random;
	private Dice dice;
	private OutputDevice outputDevice;
	
    private ArrayList<Player> players = new ArrayList<Player>();
    
    private int currentPlayerIndex = 0;

    
    public  Game(Random random, Dice dice, OutputDevice outputDevice){
       	gameCards = new GameCards();
    	gameCards.initialiceGameCards();
    	this.random = random;
    	this.dice = dice;
    	this.outputDevice = outputDevice;
    	dice.initialice(this.random);
    }


    public boolean isAWinner(){
    	boolean isAWinner = false;
    	Player player = getCurrentPlayer();
		if (random.nextInt(9) == 7) {
			isAWinner = !player.wrongAnswer();
		} else {
			isAWinner = !player.wasCorrectlyAnswered();			
		}
		nextPlayer();
		return isAWinner;
    }
    
	public boolean add(String playerName) {
		Player player = new Player(playerName, outputDevice);
		players.add(player);
	    
	    outputDevice.showMessage(playerName + " was added");
	    outputDevice.showMessage("They are player number " + players.size());
		return true;
	}
	
	public void roll() {
		int roll = dice.roll();
		Player currentPlayer = getCurrentPlayer();
		
		outputDevice.showMessage(currentPlayer.getName()  + " is the current player");
		outputDevice.showMessage("They have rolled a " + roll);

		if(currentPlayer.isInPenaltyBox()){
			if (roll % 2 != 0) {
				currentPlayer.gettingOutOfPenaltyBox();
				outputDevice.showMessage(currentPlayer.getName() + " is getting out of the penalty box");
				
				currentPlayer.move(roll);
				
				outputDevice.showMessage(currentPlayer.getName() + "'s new location is " + currentPlayer.getPlace());
				outputDevice.showMessage("The category is " + currentPlayer.getCurrentCategory());
				askQuestion();
			} else {
				outputDevice.showMessage(currentPlayer.getName() + " is not getting out of the penalty box");
				currentPlayer.keepInPenaltyBox(); 
			}
			
		} else {
		
			currentPlayer.move(roll);
			
			outputDevice.showMessage(currentPlayer.getName()
					+ "'s new location is " 
					+ currentPlayer.getPlace());
			outputDevice.showMessage("The category is " + currentPlayer.getCurrentCategory());
			askQuestion();
		}
		
	}

	private Player getCurrentPlayer() {
		Player currentPlayer = players.get(currentPlayerIndex);
		return currentPlayer;
	}

	private void askQuestion() {
		String currentCategory = getCurrentPlayer().getCurrentCategory();
		if (currentCategory.equals("Pop"))
			gameCards.askQuestion(GameCards.POP_CATEGORY);
		if (currentCategory.equals("Science"))
			gameCards.askQuestion(GameCards.SCIENCE_CATEGORY);
		if (currentCategory.equals("Sports"))
			gameCards.askQuestion(GameCards.SPORT_CATEGORY);
		if (currentCategory.equals("Rock"))
			gameCards.askQuestion(GameCards.ROCK_CATEGORY);	
	}
	
	private void nextPlayer() {
		currentPlayerIndex++;
		if (currentPlayerIndex >= players.size()) 
			currentPlayerIndex = 0;
	}
}
