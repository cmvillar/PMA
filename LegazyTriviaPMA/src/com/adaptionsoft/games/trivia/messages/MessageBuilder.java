package com.adaptionsoft.games.trivia.messages;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

import com.adaptionsoft.games.trivia.outputdevice.OutputDevice;

public class MessageBuilder {
	private OutputDevice outputDevice;
	private static Properties properties = new Properties();
	
	public MessageBuilder(OutputDevice outputDevice){
		this.outputDevice=outputDevice;
		try {
			properties.load(MessageBuilder.class.getResourceAsStream("mensajes_param.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getValue(String key){
		return properties.getProperty(key);
	}
	
	public void showRollDice(int roll) {
		outputDevice.showMessage(MessageFormat.format(getValue("player.roll"),roll));
	}
	
	public void showCurrentPlayer(String name) {
		outputDevice.showMessage(MessageFormat.format(getValue("player.name"),name));
	}


	public void showPlayerIsNotGettingOutOfPenaltyBox(String name) {
		outputDevice.showMessage(MessageFormat.format(getValue("player.is.not.getting.out.penalty"),name));
	}


	public void showPlayerIsGettingOutOfPenaltyBox(String name) {
		outputDevice.showMessage(MessageFormat.format(getValue("player.is.getting.out.penalty"),name));
	}


	public void showCurrentLocationAndCategory(String name, int place, String category) {
		outputDevice.showMessage(MessageFormat.format(getValue("player.new.location"),new Object[]{name,"'",place}));
		outputDevice.showMessage(MessageFormat.format(getValue("category"),category));
	}
	
	public void showPlayerSentToPenalty(String name) {
		outputDevice.showMessage(MessageFormat.format(getValue("player.sent.penalty"),name));
	}

	public void showQuestionWasIncorrectlyAnswerd() {
		outputDevice.showMessage(getValue("question.incorrenctly.answered"));
	}
	
	public void showPlayerGoldenCoins(String name, int purses) {
		outputDevice.showMessage(MessageFormat.format(getValue("golden.coins"),name,purses));
	}

	public void showAnswerWasCorrect() {
		outputDevice.showMessage(getValue("answer.correct"));
	}

	public void showNumberOfPlayers(int numberOfPlayers) {
		outputDevice.showMessage(MessageFormat.format(getValue("number.of.players") ,numberOfPlayers));
	}
	
	public void showPlayerNameAdded(String playerName) {
		outputDevice.showMessage(MessageFormat.format(getValue("user.added"),playerName));
	}
}
