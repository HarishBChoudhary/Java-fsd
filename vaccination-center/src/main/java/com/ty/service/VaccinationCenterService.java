package com.ty.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.entity.Citizen;
import com.ty.entity.VaccinationCenter;
import com.ty.repositry.CitizenRepository;
import com.ty.repositry.VaccinationCenterRepository;

@Service
public class VaccinationCenterService {

	@Autowired
	private VaccinationCenterRepository vaccinationRepository;

	@Autowired
	private CitizenRepository CitizenRepository;

	public VaccinationCenter add_Or_updateCenter(VaccinationCenter center) {

		return vaccinationRepository.save(center);
	}

	public List<VaccinationCenter> getVaccinationCenters() {

		List<VaccinationCenter> centers = StreamSupport.stream(vaccinationRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return centers;

	}

	public boolean delete(long id) {

		VaccinationCenter center = vaccinationRepository.findById(id).get();

		List<Citizen> citizens = CitizenRepository.findAllByCenterId(id);

		citizens.forEach(e -> {
			e.setCenter(null);
			CitizenRepository.save(e);
		});

		vaccinationRepository.delete(center);
		return true;
	}

	public VaccinationCenter getVaccinationCenterById(long id) {

		return vaccinationRepository.findById(id).get();
	}
}
