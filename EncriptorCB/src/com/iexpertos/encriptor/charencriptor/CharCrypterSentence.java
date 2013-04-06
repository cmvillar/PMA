package com.iexpertos.encriptor.charencriptor;

public class CharCrypterSentence implements CharCrypter {

	@Override
	public String crypt(int charValue){
		return String.valueOf((char)( charValue + 2));
	}
}