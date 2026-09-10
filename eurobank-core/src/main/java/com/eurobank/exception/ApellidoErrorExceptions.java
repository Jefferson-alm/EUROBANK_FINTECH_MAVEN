package com.eurobank.exception;

public class ApellidoErrorExceptions extends Exception {

	private static final long serialVersionUID = 1L;

	public ApellidoErrorExceptions(String apellido) {
		super(apellido);
	}
	
}
