package com.adaptionsoft.games.trivia.runner;

import java.util.LinkedList;

public class GameCards{
	public static int POP_CATEGORY = 0;
	public static int SCIENCE_CATEGORY = 1;
	public static int SPORT_CATEGORY = 2;
	public static int ROCK_CATEGORY = 3;
	
    private LinkedList<String> popQuestions = new LinkedList<String>();
    private LinkedList<String> scienceQuestions = new LinkedList<String>();
    private LinkedList<String> sportsQuestions = new LinkedList<String>();
    private LinkedList<String> rockQuestions = new LinkedList<String>();
    
    public GameCards(){
    	
    }
    
    public void initialiceGameCards(){
    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast("Rock Question " + i);
    	}
    }
    
	public void askQuestion(int categoryCard) {
		if (categoryCard == POP_CATEGORY)
			System.out.println(popQuestions.removeFirst());
		if (categoryCard == SCIENCE_CATEGORY)
			System.out.println(scienceQuestions.removeFirst());
		if (categoryCard == SPORT_CATEGORY)
			System.out.println(sportsQuestions.removeFirst());
		if (categoryCard == ROCK_CATEGORY)
			System.out.println(rockQuestions.removeFirst());		
	}
}
