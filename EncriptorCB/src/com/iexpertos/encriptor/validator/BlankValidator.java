package com.iexpertos.encriptor.validator;

import java.security.InvalidParameterException;

public class BlankValidator implements Validator{
	/**
	 * MŽtodo que determina si es v‡lida la palabra que se le pasa.
	 * Una palabra es v‡lida si no contiene espacios
	 * @param word palabra que no puede ser nula
	 * @throws InvalidParameterExcepcion
	 */
	@Override
	public void validate(String word) {
		if (word.contains(" "))
			throw new InvalidParameterException();
	}
}
