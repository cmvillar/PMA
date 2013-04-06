package com.iexpertos.encriptor;

import java.security.InvalidParameterException;

import com.iexpertos.encriptor.charencriptor.CharCrypter;
import com.iexpertos.encriptor.charencriptor.CharCrypterSentence;
import com.iexpertos.encriptor.charencriptor.CharCrypterWordReplace;
import com.iexpertos.encriptor.charencriptor.CharCrypterWordToNumber;
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
		return crypt(sentence, new CharCrypterSentence());
	}
	
	public String cryptWordToNumbers(String word)
	{
		validator.validate(word);
		return crypt(word, new CharCrypterWordToNumber());
	}

	public String cryptWord(String word, String charsToReplace)
	{
		validator.validate(word);
		return crypt(word, new CharCrypterWordReplace(charsToReplace));
	}
	
	private String crypt(String word, CharCrypter crypter){
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
