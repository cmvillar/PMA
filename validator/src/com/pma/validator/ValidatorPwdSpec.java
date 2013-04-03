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
		return true;
	}

	@Test
	public void validateLengthBiggerEqualFour() {
		Assert.assertEquals(true, validate("xxxxx"));
	}

}
