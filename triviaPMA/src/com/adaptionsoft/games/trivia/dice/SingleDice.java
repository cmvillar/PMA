package com.adaptionsoft.games.trivia.dice;

import java.util.Random;

public class SingleDice extends Dice{

	public SingleDice(Random rand){
		super(rand);
	}
	
	public int roll(){
		return rand.nextInt(5) + 1;
	}
}
