package com.iexpertos.encriptor;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.iexpertos.encriptor.validator.BlankValidator;

public class EncriptorSpec {
	private Encriptor encriptor;

	/**
	 * Tomando como referencia las entradas y salidas obtenidas en el main realizaremos los tests correspondientes
	 * cryptWord("hola") -> jqnc
	 * cryptWordToNumbers("hola") -> 10611311099
	 * cryptWord("hola", "o") -> hqla
	 * cryptSentence("hola, que tal estas?") -> jqnc."swg"vcn"guvcuA
	 * printWords("hola, que tal estas?") -> <hola,><que><tal><estas?>
	 */

	@Before
	public void setUp(){
		encriptor = new Encriptor(new BlankValidator());
	}
	
	@Test
	public void cryptWord() {
		Assert.assertEquals(encriptor.cryptWord("hola"), "jqnc");
	}

	@Test
	public void cryptSentence() {
		Assert.assertEquals(encriptor.cryptSentence("hola, que tal estas?"), "jqnc.\"swg\"vcn\"guvcuA");
	}
	
	@Test(expected=NullPointerException.class)
	public void checkNullWord(){
		Assert.assertEquals(encriptor.cryptWord(null),null);
	}
	
	@Test
	public void cryptWordToNumbers() {
		Assert.assertEquals(encriptor.cryptWordToNumbers("hola"),"10611311099");
	}
	
	@Test
	public void cryptWordToReplace() {
		Assert.assertEquals(encriptor.cryptWord("hola", "o"),"hqla");
	}
	
	@Test
	public void getWords() {
		Assert.fail();
	}

}
