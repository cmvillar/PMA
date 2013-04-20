package com.adaptionsoft.games.trivia.dice;

public class TenSidedDice extends Dice{
	public int roll(){
		return rand.nextInt(9) + 1;
	}
}
