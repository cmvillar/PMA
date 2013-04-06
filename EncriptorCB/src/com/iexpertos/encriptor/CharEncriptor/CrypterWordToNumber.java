package com.iexpertos.encriptor.CharEncriptor;

public class CrypterWordToNumber implements Crypter{
	
	@Override
	public String crypt(int charValue){
		return String.valueOf(charValue + 2);
	}
}
