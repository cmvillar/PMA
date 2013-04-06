package com.iexpertos.encriptor.validator;

import java.security.InvalidParameterException;

public class BlankValidator implements Validator{
	
	@Override
	public void validate(String word) {
		if (word.contains(" "))
			throw new InvalidParameterException();
	}
}
