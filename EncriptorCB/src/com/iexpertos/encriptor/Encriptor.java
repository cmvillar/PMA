package com.iexpertos.encriptor;

import java.security.InvalidParameterException;

import com.iexpertos.encriptor.charencriptor.CharCrypter;
import com.iexpertos.encriptor.charencriptor.CharCrypterSentence;
import com.iexpertos.encriptor.charencriptor.CharCrypterWordReplace;
import com.iexpertos.encriptor.charencriptor.CharCrypterWordToNumber;
import com.iexpertos.encriptor.validator.Validator;


public class Encriptor {
	
	private Validator validator;
	private CharCrypterSentence charCrypterSentence;
	private CharCrypterWordToNumber charCrypterWordToNumber;
	private CharCrypterWordReplace charCrypterWordReplace;
	
	/* ------------- SETTERS ------------------ */
	
	public void setCharCrypterSentence(CharCrypterSentence charCrypterSentence) {
		this.charCrypterSentence = charCrypterSentence;
	}


	public void setCharCrypterWordToNumber(
			CharCrypterWordToNumber charCrypterWordToNumber) {
		this.charCrypterWordToNumber = charCrypterWordToNumber;
	}


	public void setCharCrypterWordReplace(
			CharCrypterWordReplace charCrypterWordReplace) {
		this.charCrypterWordReplace = charCrypterWordReplace;
	}
	
	/* ----------------------------------------- */
	
	public Encriptor(Validator validator){
		this.validator = validator;
	}
	
	
	public String cryptWord(String word)
	{
		validator.validate(word);		
		return cryptSentence(word);
	}

	public String cryptSentence(String sentence)
	{
		return crypt(sentence, charCrypterSentence);
	}
	
	public String cryptWordToNumbers(String wordToCrypt)
	{
		validator.validate(wordToCrypt);
		return crypt(wordToCrypt, charCrypterWordToNumber);
	}

	public String cryptWord(String wordToCrypt, String charsToReplace)
	{
		validator.validate(wordToCrypt);
		charCrypterWordReplace.setCharsToReplace(charsToReplace);
		return crypt(wordToCrypt, charCrypterWordReplace);
	}
	
	private String crypt(String wordToCrypt, CharCrypter crypter){	
		char[] charsWordToCryptArray = wordToCrypt.toCharArray();
		String encryptedWord = "";
		for (char word : charsWordToCryptArray){
			encryptedWord += crypter.crypt(word);
		}
		return encryptedWord;
	}
	

	public String[] getWords(String sentence)
	{
		return sentence.split(" ");
	}
	
	public void printWords(String sentence)
	{
		String[] words = getWords(sentence);
		for (String word : words)
		{
			System.out.print("<" + word + ">");
		}
	}
	
}
