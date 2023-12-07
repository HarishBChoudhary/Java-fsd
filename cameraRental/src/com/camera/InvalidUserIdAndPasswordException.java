package com.camera;

public class InvalidUserIdAndPasswordException extends Exception{

	String message;

	public InvalidUserIdAndPasswordException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
