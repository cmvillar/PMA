package com.iexpertos.encriptor.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.iexpertos.encriptor.Encriptor;
import com.iexpertos.encriptor.charencriptor.CharCrypterSentence;
import com.iexpertos.encriptor.charencriptor.CharCrypterWordReplace;
import com.iexpertos.encriptor.charencriptor.CharCrypterWordToNumber;
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
		encriptor.setCharCrypterSentence(new CharCrypterSentence());
		encriptor.setCharCrypterWordReplace(new CharCrypterWordReplace());
		encriptor.setCharCrypterWordToNumber(new CharCrypterWordToNumber());

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
		String[] resultadoEsperado = new String[]{"hola,","que", "tal", "estas?"};			
		Assert.assertEquals(encriptor.getWords("hola, que tal estas?"), resultadoEsperado);
	}
	
	
	class Checker extends OutputStream{
		Checksum checksum = new CRC32();
		public void write (int b) throws IOException{
			checksum.update(b);
		}
	}
	
	@Test
	public void printWords() {
		Checker checker = new Checker();
		System.setOut(new PrintStream(checker));
		encriptor.printWords("hola, que tal estas?");
		Assert.assertEquals(1719384139L, checker.checksum.getValue());
		
	}

}
