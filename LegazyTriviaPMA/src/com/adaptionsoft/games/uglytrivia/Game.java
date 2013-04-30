package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.adaptionsoft.games.trivia.dice.Dice;
import com.adaptionsoft.games.trivia.messages.MessageBuilder;
import com.adaptionsoft.games.trivia.outputdevice.OutputDevice;
import com.adaptionsoft.games.trivia.runner.GameCards;


public class Game {
	private GameCards gameCards;
	private Random random;
	private Dice dice;
	private MessageBuilder messageBuilder;
	
    private ArrayList<Player> players = new ArrayList<Player>();
    
    private int currentPlayerIndex = 0;

    
    public  Game(Random random, Dice dice, OutputDevice outputDevice){
       	gameCards = new GameCards();
    	gameCards.initialiceGameCards();
    	this.random = random;
    	this.dice = dice;
    	this.messageBuilder = new MessageBuilder(outputDevice);
    	dice.initialice(this.random);
    }


    public boolean isAWinner(){
    	boolean isAWinner = false;
    	Player player = getCurrentPlayer();
		if (random.nextInt(9) == 7) {
			player.wrongAnswer();
		} else {
			isAWinner = !player.wasCorrectlyAnswered();			
		}
		nextPlayer();
		return isAWinner;
    }
    
    public List<Player> getPlayers(){
    	return players;
    }
    
	public boolean addPLayer(String playerName) {
		Player player = new Player(playerName);
		player.setMessageManager(messageBuilder);
		players.add(player);
	    
	    messageBuilder.showPlayerNameAdded(playerName);
	    messageBuilder.showNumberOfPlayers(players.size());
		return true;
	}
	
	public void removePlayer(String playerName){
		Player playerToRemove = new Player(playerName);
		players.remove(playerToRemove);
	}

	public void roll() {
		int roll = dice.roll();
		Player currentPlayer = getCurrentPlayer();
		
		messageBuilder.showCurrentPlayer(currentPlayer.getName());
		messageBuilder.showRollDice(roll);

		if(currentPlayer.isInPenaltyBox()){
			if (roll % 2 != 0) {
				currentPlayer.gettingOutOfPenaltyBox();
				messageBuilder.showPlayerIsGettingOutOfPenaltyBox(currentPlayer.getName());
				currentPlayer.move(roll);		
				messageBuilder.showCurrentLocationAndCategory(currentPlayer.getName(),
						currentPlayer.getPlace(), currentPlayer.getCurrentCategory());
				askQuestion();
			} else {
				messageBuilder.showPlayerIsNotGettingOutOfPenaltyBox(currentPlayer.getName());
				currentPlayer.keepInPenaltyBox(); 
			}
			
		} else {
		
			currentPlayer.move(roll);
			messageBuilder.showCurrentLocationAndCategory(currentPlayer.getName(),
					currentPlayer.getPlace(), currentPlayer.getCurrentCategory());
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
