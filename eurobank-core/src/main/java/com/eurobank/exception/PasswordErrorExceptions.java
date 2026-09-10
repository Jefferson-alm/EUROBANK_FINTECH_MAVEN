package com.eurobank.exception;

public class PasswordErrorExceptions extends Exception {


	private static final long serialVersionUID = 1L;
	
	public PasswordErrorExceptions(String password) {
		super(password);
	}

}
