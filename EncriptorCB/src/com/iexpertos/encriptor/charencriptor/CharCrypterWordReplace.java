package com.iexpertos.encriptor.charencriptor;

public class CharCrypterWordReplace implements CharCrypter {

	private char[] replacement;
	
	public CharCrypterWordReplace(String charsToReplace){
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
