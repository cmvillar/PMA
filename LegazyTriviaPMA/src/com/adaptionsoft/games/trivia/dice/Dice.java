package com.adaptionsoft.games.trivia.dice;

import java.util.Random;

public abstract class Dice {
	protected Random rand;
	
	public abstract int roll();
	public void initialice(Random random){
		this.rand = random;
	}
}
