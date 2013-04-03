package com.pma.validator;

import static org.junit.Assert.*;
import junit.framework.Assert;

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
	private boolean validate(String pwd){
		return (pwd.length()>=4) && (pwd.matches("[a-z]+"));
	}

	@Test
	public void checkValidPwd_LengthBiggerOrEqualFour() {
		Assert.assertEquals(true, validate("xxxxx"));
	}
	
	@Test
	public void checkInvalidPwdLength(){
		Assert.assertFalse(validate(""));
	}
	
	@Test
	public void ckeckAtLeastOneLowerCaseChar(){
		Assert.assertTrue(validate("aaaa"));
	}
}
