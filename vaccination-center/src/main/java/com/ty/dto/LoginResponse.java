package com.ty.dto;

public class LoginResponse {

	private String email, name, encodedToken;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEncodedToken() {
		return encodedToken;
	}

	public void setEncodedToken(String encodedToken) {
		this.encodedToken = encodedToken;
	}

}
