package com.ty.entity;

import com.ty.entity.VaccinationCenter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Citizen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String city;
	
	@ManyToOne
	@JoinColumn(name="vaccination_centerId")
	private VaccinationCenter center;
	
	private int vaccintn_count;
	
	@Transient
	private String vaccinationStatus;

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

	public VaccinationCenter getCenter() {
		return center;
	}

	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}

	public int getVaccintn_count() {
		return vaccintn_count;
	}

	public void setVaccintn_count(int vaccintn_count) {
		this.vaccintn_count = vaccintn_count;
	}

	public String getVaccinationStatus() {
		return getVaccintn_count() == 2 ? "Fully_Vaccinated":"Not_Fully_Vaccinated";
	}

	public void setVaccinationStatus(String vaccinationStatus) {
		this.vaccinationStatus = vaccinationStatus;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
