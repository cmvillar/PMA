package com.pma.validator;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Esta clase define las especificaciones que debe cumplir el validador
 * 1.- tendr‡ que tener al menos un nœmero y una letra
 * 2.- tendr‡ que tener al menos alguna mayœscula
 * 3.- tendr‡ que tener una longitud mayor o igual a 4 caracteres
 * 4.- tendr‡ que tener al menos una minœscula
 * @author cmvillar
 *
 */

public class ValidatorPwdSpec {
	private ValidatorPwd validator;
	
	@Before
	public void setup(){
		validator = new ValidatorPwdImpl();
	}
	
	@Test
	public void checkValidPwd_LengthBiggerOrEqualFour() {
		Assert.assertEquals(true, validator.validate("xaxA1"));
	}
	
	@Test
	public void checkInvalidPwdLength(){
		Assert.assertFalse(validator.validate(""));
	}
	
	@Test
	public void ckeckAtLeastOneLowerCaseChar(){
		Assert.assertTrue(validator.validate("AaA1AA"));
	}
	
	@Test
	public void ckeckAtLeastOneUpperCaseChar(){
		Assert.assertTrue(validator.validate("aa1aAx"));
	}
	
	@Test
	public void ckeckAtLeastANumberAndALetter(){
		Assert.assertTrue(validator.validate("1111aA"));
	}
}
