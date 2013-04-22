package com.adaptionsoft.games.uglytrivia;

class Player{
	private int purses;
	private boolean isInPenaltyBox;
	private boolean isGettingOutOfPenaltyBox;
	private String name;
	private int place;
	
	public Player(String name){
		this.name = name;
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
	
	/*public void setInPenaltyBox(boolean isInPenaltyBox){
		this.isInPenaltyBox = isInPenaltyBox;
	}*/
	
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
		System.out.println("Question was incorrectly answered");
		System.out.println(name+ " was sent to the penalty box");
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
		System.out.println("Answer was correct!!!!");
		incPurses();
		System.out.println(name
				+ " now has "
				+ purses
				+ " Gold Coins.");
		
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
