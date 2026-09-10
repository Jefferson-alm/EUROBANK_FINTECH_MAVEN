package com.eurobank.exception;

public class UserErrorExceptions extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UserErrorExceptions(String user_name) {
		super(user_name);
	}

	
}
