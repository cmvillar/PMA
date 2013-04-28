package com.adaptionsoft.games.trivia.messages;

import com.adaptionsoft.games.trivia.outputdevice.OutputDevice;

public class MessageBuilder {
	private OutputDevice outputDevice;
	
	public MessageBuilder(OutputDevice outputDevice){
		this.outputDevice=outputDevice;
	}
	
	public void showRollDice(int roll) {
		outputDevice.showMessage(MessageManager.getInstance().getValue("player.roll")+" "+ roll);
	}
	
	public void showCurrentPlayer(String name) {
		outputDevice.showMessage(name + " " + MessageManager.getInstance().getValue("player.name"));
	}


	public void showPlayerIsNotGettingOutOfPenaltyBox(String name) {
		outputDevice.showMessage(name + " " + MessageManager.getInstance().getValue("player.is.not.getting.out.penalty"));
	}


	public void showPlayerIsGettingOutOfPenaltyBox(String name) {
		outputDevice.showMessage(name + " " + MessageManager.getInstance().getValue("player.is.getting.out.penalty"));
	}


	public void showCurrentLocationAndCategory(String name, int place, String category) {
		outputDevice.showMessage(name + MessageManager.getInstance().getValue("player.new.location")+" "+place);
		outputDevice.showMessage(MessageManager.getInstance().getValue("category")+" "+category);
	}
	
	public void showPlayerSentToPenalty(String name) {
		outputDevice.showMessage(name+ " " + MessageManager.getInstance().getValue("player.sent.penalty"));
	}

	public void showQuestionWasIncorrectlyAnswerd() {
		outputDevice.showMessage(MessageManager.getInstance().getValue("question.incorrenctly.answered"));
	}
	
	public void showPlayerGoldenCoins(String name, int purses) {
		outputDevice.showMessage(name + " " + MessageManager.getInstance().getValue("golden.coins.has")
				+ " " + purses + " " + MessageManager.getInstance().getValue("golden.coins.goldcoins"));
	}

	public void showAnswerWasCorrect() {
		outputDevice.showMessage(MessageManager.getInstance().getValue("answer.correct"));
	}

	public void showNumberOfPlayers(int numberOfPlayers) {
		outputDevice.showMessage(MessageManager.getInstance().getValue("number.of.players") + " " + numberOfPlayers);
	}
	
	public void showPlayerNameAdded(String playerName) {
		outputDevice.showMessage(playerName+ " " + MessageManager.getInstance().getValue("user.added"));
	}
}
