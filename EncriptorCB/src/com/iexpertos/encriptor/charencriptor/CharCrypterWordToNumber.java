package com.iexpertos.encriptor.charencriptor;

public class CharCrypterWordToNumber implements CharCrypter{
	
	@Override
	public String crypt(int charValue){
		return String.valueOf(charValue + 2);
	}
}
