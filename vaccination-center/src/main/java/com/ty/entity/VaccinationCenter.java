package com.ty.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class VaccinationCenter {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String address;
	
	@OneToMany(mappedBy = "center",cascade = CascadeType.REMOVE,orphanRemoval = true)
	private List<Citizen> citizensList;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Citizen> getCitizensList() {
		return citizensList;
	}

	public void setCitizensList(List<Citizen> citizensList) {
		this.citizensList = citizensList;
	}
	
}
