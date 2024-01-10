package com.ty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ty.entity.Citizen;
import com.ty.entity.VaccinationCenter;
import com.ty.repositry.CitizenRepository;
import com.ty.repositry.VaccinationCenterRepository;

@SpringBootApplication
public class VaccinationCenterApplication implements CommandLineRunner{

	@Autowired
	private CitizenRepository citizenRepository;

	@Autowired
	private VaccinationCenterRepository vaccinationCenterRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(VaccinationCenterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Citizen citizen = new Citizen();
		citizen.setCity("CITY_1");
		citizen.setName("NAME_1");

		citizenRepository.save(citizen);

		VaccinationCenter vc = new VaccinationCenter();
		vc.setName("CLINIC_1");
		vc.setAddress("BLR1");

		vaccinationCenterRepository.save(vc);

		citizen.setCenter(vc);

		citizenRepository.save(citizen);
		
	}

	
}
