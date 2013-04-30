package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.trivia.messages.MessageBuilder;


public class Player{
	private int purses;
	private boolean isInPenaltyBox;
	private boolean isGettingOutOfPenaltyBox;
	private String name;
	private int place;
	private MessageBuilder messageManager;
	
	public Player(String name){
		this.name = name;
	}
	
	private void incPurses(){
		purses++;
	}
	
	public void setMessageManager(MessageBuilder messageManager){
		this.messageManager = messageManager;
	}
	
	public void putInPenaltyBox(){
		this.isInPenaltyBox = true;
	}
	
	public String getName(){
		return name;
	}
	
	public int getPlace(){
		return place;
	}
	
	public boolean isInPenaltyBox(){
		return this.isInPenaltyBox;
	}
	
	public boolean isGettingOutOfPenaltyBox(){
		return isGettingOutOfPenaltyBox;
	}
	
	public void gettingOutOfPenaltyBox(){
		this.isGettingOutOfPenaltyBox = true;
	}
	public void keepInPenaltyBox(){
		this.isGettingOutOfPenaltyBox = false;
	}
	
	public void move(int roll){
		place = place+ roll;
		if (place > 11) 
			place = place - 12;
	}

	/**
	 * A Player wins when purses==6
	 * @return
	 */
	private boolean isPlayerWinner() {
		return !(purses== 6);
	}


	public void wrongAnswer(){
		messageManager.showQuestionWasIncorrectlyAnswerd();
		messageManager.showPlayerSentToPenalty(name);
		isInPenaltyBox = true;
	}
	
	public boolean wasCorrectlyAnswered() {
		boolean correctAnswer = false;
		if (isInPenaltyBox){
			if (isGettingOutOfPenaltyBox) {
				correctAnswer = answerWasCorrect();
			} else {
				correctAnswer = true;
			}
			
		} else {
		
			correctAnswer = answerWasCorrect();
		}
		return correctAnswer;
	}

	private boolean answerWasCorrect() {
		messageManager.showAnswerWasCorrect();
		incPurses();
		messageManager.showPlayerGoldenCoins(name, purses);
		return isPlayerWinner();
	}	
	
	public String getCurrentCategory() {
		if (place == 0) return "Pop";
		if (place == 4) return "Pop";
		if (place == 8) return "Pop";
		if (place == 1) return "Science";
		if (place == 5) return "Science";
		if (place == 9) return "Science";
		if (place == 2) return "Sports";
		if (place == 6) return "Sports";
		if (place == 10) return "Sports";
		return "Rock";
	}
	
	public boolean equals (Object o){
		if(o!=null && o instanceof Player){
			return name.equals(((Player)o).getName());
		}else{
			return false;
		}
			
	}
}
