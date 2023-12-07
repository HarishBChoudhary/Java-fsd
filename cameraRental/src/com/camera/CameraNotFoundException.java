package com.camera;

public class CameraNotFoundException extends Exception{

	String message;

	public CameraNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	 public String getMessage() {
		 return message;
	 }
	 
}
