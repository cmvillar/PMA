package com.iexpertos.encriptor;

import com.iexpertos.encriptor.charencriptor.CharCrypterSentence;
import com.iexpertos.encriptor.charencriptor.CharCrypterWordReplace;
import com.iexpertos.encriptor.charencriptor.CharCrypterWordToNumber;
import com.iexpertos.encriptor.validator.BlankValidator;

public class Main {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		Encriptor encriptor = new Encriptor(new BlankValidator());
		encriptor.setCharCrypterSentence(new CharCrypterSentence());
		encriptor.setCharCrypterWordReplace(new CharCrypterWordReplace());
		encriptor.setCharCrypterWordToNumber(new CharCrypterWordToNumber());
		
		System.out.println("1:" + encriptor.cryptWord("hola"));
		System.out.println("2:" + encriptor.cryptWordToNumbers("hola"));
		System.out.println("3:" + encriptor.cryptWord("hola", "o"));
		System.out.println("4:" + encriptor.cryptSentence("hola, que tal estas?"));
		encriptor.printWords("hola, que tal estas?");

	}

}
