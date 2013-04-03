package com.pma.validator;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

/**
 * Esta clase define las especificaciones que debe cumplir el validador
 * 1.- tendr� que tener al menos un n�mero y una letra
 * 2.- tendr� que tener al menos alguna may�scula
 * 3.- tendr� que tener una longitud mayor o igual a 4 caracteres
 * 4.- tendr� que tener al menos una min�scula
 * @author cmvillar
 *
 */

public class ValidatorPwdSpec {
	private boolean validate(String pwd){
		return pwd.length()>=4;
	}

	@Test
	public void validateLengthBiggerEqualFour() {
		Assert.assertEquals(true, validate("xxxxx"));
	}
	
	@Test
	public void checkInvalidPwdLength(){
		Assert.assertFalse(validate(""));
	}

}
