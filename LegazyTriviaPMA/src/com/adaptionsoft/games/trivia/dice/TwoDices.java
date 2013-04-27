package com.adaptionsoft.games.trivia.dice;

public class TwoDices extends Dice{
	public int roll(){
		return (rand.nextInt(9) + 1)+(rand.nextInt(9) + 1);
	}
}
