package com.iexpertos.encriptor.CharEncriptor;

public class CrypterWordReplace implements Crypter {

	private char[] replacement;
	
	public CrypterWordReplace(String charsToReplace){
		this.replacement = charsToReplace.toCharArray();
	}
	
	@Override
	public String crypt(int charValue) {
		char result = (char)charValue;
		 
		for (int j = 0; j < replacement.length; j++)
		{
			if (replacement[j] == result)
			{
				result = (char)( charValue + 2);		
			}
		}
		return String.valueOf(result);
	}
}
