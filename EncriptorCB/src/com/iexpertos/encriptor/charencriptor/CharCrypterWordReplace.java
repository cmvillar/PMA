package com.iexpertos.encriptor.charencriptor;

public class CharCrypterWordReplace implements CharCrypter {

	private char[] charsToReplace;

	public void setCharsToReplace(String charsToReplace){
		this.charsToReplace = charsToReplace.toCharArray();
	}
	
	@Override
	public String crypt(int charValue) {
		char result = (char)charValue;
		for(char replaceChar: charsToReplace){
			if (replaceChar == result)
			{
				result = (char)( charValue + 2);		
			}
		}
		 
		return String.valueOf(result);
	}
}
