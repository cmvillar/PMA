package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.trivia.outputdevice.OutputDevice;

class Player{
	private int purses;
	private boolean isInPenaltyBox;
	private boolean isGettingOutOfPenaltyBox;
	private String name;
	private int place;
	private OutputDevice outputDevice;
	
	public Player(String name, OutputDevice outputDevice){
		this.name = name;
		this.outputDevice = outputDevice;
	}
	
	private void incPurses(){
		purses++;
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

	private boolean didPlayerWin() {
		return !(purses== 6);
	}


	public boolean wrongAnswer(){
		outputDevice.showMessage("Question was incorrectly answered");
		outputDevice.showMessage(name+ " was sent to the penalty box");
		isInPenaltyBox = true;
		return true;
	}
	
	public boolean wasCorrectlyAnswered() {
		boolean winner = false;
		if (isInPenaltyBox){
			if (isGettingOutOfPenaltyBox) {
				winner = answerWasCorrect();
			} else {
				winner = true;
			}
			
		} else {
		
			winner = answerWasCorrect();
		}
		return winner;
	}

	private boolean answerWasCorrect() {
		boolean winner;
		outputDevice.showMessage("Answer was correct!!!!");
		incPurses();
		outputDevice.showMessage(name + " now has " + purses + " Gold Coins.");
		winner = didPlayerWin();
		return winner;
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
}
