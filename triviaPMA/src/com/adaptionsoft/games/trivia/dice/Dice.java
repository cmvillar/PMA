package com.adaptionsoft.games.trivia.dice;

import java.util.Random;

public abstract class Dice {
	protected final Random rand;
	
	public Dice(Random rand){
		this.rand = rand;
	}
	
	public abstract int roll();
}
