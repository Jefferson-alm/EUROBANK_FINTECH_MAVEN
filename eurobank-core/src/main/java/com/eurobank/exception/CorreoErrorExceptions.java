package com.eurobank.exception;

public class CorreoErrorExceptions extends Exception {

	private static final long serialVersionUID = 1L;

	public CorreoErrorExceptions(String correo) {
		super(correo);
	}
	
}
