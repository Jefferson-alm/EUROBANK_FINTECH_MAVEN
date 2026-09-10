package com.eurobank.exception;

public class TelefonoErrorExceptions extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TelefonoErrorExceptions(String telefono) {
		super(telefono);
	}

}
