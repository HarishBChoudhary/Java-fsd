package com.camera;

public class InsufficientWalletBalanceException extends Exception{

	String message;

	public InsufficientWalletBalanceException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
}
