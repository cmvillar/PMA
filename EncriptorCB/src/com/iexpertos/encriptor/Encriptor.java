package com.iexpertos.encriptor;

import java.security.InvalidParameterException;

import com.iexpertos.encriptor.CharEncriptor.Crypter;
import com.iexpertos.encriptor.CharEncriptor.CrypterSentence;
import com.iexpertos.encriptor.CharEncriptor.CrypterWordToNumber;


public class Encriptor {
	
	public Crypter crypterSentence;
	public CrypterWordToNumber crypterWordToNumber;
	
	public Encriptor(){
		crypterSentence = new CrypterSentence();
		crypterWordToNumber = new CrypterWordToNumber();
	}
	
	private void validateBlankSpaces(String word) {
		if (word.contains(" "))
			throw new InvalidParameterException();
	}
	
	public String cryptWord(String word)
	{
		validateBlankSpaces(word);		
		return cryptSentence(word);
	}

	public String cryptSentence(String sentence)
	{
		char[] sentenceArray = sentence.toCharArray();
		String newWord = "";
		for (int i = 0; i < sentence.length(); i++)
		{
			newWord += crypterSentence.crypt(sentenceArray[i]);
		}
		
		return newWord;
	}
	
	public String cryptWordToNumbers(String word)
	{
		validateBlankSpaces(word);
		
		char[] wordArray = word.toCharArray();
		String newWord = "";
		for (int i = 0; i < word.length(); i++)
		{
			newWord += crypterWordToNumber.crypt(wordArray[i]);
		}
		
		return newWord;
	}

	public String cryptWord(String word, String charsToReplace)
	{
		validateBlankSpaces(word);
		
		char[] wordArray = word.toCharArray();
		char[] replacement = charsToReplace.toCharArray();
		char[] result = wordArray.clone();
		for (int i = 0; i < wordArray.length; i++)
		{
			for (int j = 0; j < replacement.length; j++)
			{
				if (replacement[j] == wordArray[i])
				{
					int charValue = wordArray[i];
					result[i] = (char)( charValue + 2);		
				}
			}
		}
		return String.valueOf(result);
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
