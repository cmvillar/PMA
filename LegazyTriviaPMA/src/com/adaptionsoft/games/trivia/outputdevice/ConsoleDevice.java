package com.adaptionsoft.games.trivia.outputdevice;

public class ConsoleDevice implements OutputDevice{

	@Override
	public void showMessage(Object obj) {
		System.out.println(obj);
	}
}
