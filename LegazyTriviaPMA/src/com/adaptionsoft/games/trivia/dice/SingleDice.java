package com.adaptionsoft.games.trivia.dice;

public class SingleDice extends Dice{
	
	public int roll(){
		return rand.nextInt(5) + 1;
	}
}
