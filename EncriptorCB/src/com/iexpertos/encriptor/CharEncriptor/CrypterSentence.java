package com.iexpertos.encriptor.CharEncriptor;

public class CrypterSentence implements Crypter {

	@Override
	public String crypt(int charValue){
		return String.valueOf((char)( charValue + 2));
	}
}