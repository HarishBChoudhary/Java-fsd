package com.ty.dto;

import com.ty.validator.CitizenValidator;

@CitizenValidator
public class CitizenDto {

	private String httpMethod;
	
	private long id;
	private String name,city;
	private int doesCount;
	private long centerId;
	
	
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHtttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getDoesCount() {
		return doesCount;
	}
	public void setDoesCount(int doesCount) {
		this.doesCount = doesCount;
	}
	public long getCenterId() {
		return centerId;
	}
	public void setCenterId(long centerId) {
		this.centerId = centerId;
	}
	
	
}
