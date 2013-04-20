package com.adaptionsoft.games.trivia.runner;

import java.util.LinkedList;

public class GameCards{
    public LinkedList popQuestions = new LinkedList();
    public LinkedList scienceQuestions = new LinkedList();
    public LinkedList sportsQuestions = new LinkedList();
    public LinkedList rockQuestions = new LinkedList();
    
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
}
