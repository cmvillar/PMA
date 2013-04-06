package com.iexpertos.encriptor;

import java.security.InvalidParameterException;

import com.iexpertos.encriptor.CharEncriptor.Crypter;
import com.iexpertos.encriptor.CharEncriptor.CrypterSentence;
import com.iexpertos.encriptor.CharEncriptor.CrypterWordReplace;
import com.iexpertos.encriptor.CharEncriptor.CrypterWordToNumber;
import com.iexpertos.encriptor.validator.Validator;


public class Encriptor {
	
	public Validator validator;
	
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
		return crypt(sentence, new CrypterSentence());
	}
	
	public String cryptWordToNumbers(String word)
	{
		validator.validate(word);
		return crypt(word, new CrypterWordToNumber());
	}

	public String cryptWord(String word, String charsToReplace)
	{
		validator.validate(word);
		return crypt(word, new CrypterWordReplace(charsToReplace));
	}
	
	private String crypt(String word, Crypter crypter){
		char[] wordArray = word.toCharArray();
		String newWord = "";
		for (int i = 0; i < word.length(); i++)
		{
			newWord += crypter.crypt(wordArray[i]);
		}
		
		return newWord;
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
