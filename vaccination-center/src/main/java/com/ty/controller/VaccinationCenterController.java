package com.ty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.dto.VaccinationCenterDto;
import com.ty.entity.VaccinationCenter;
import com.ty.service.VaccinationCenterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "vaccinationcenter",produces="application/json")
public class VaccinationCenterController {

	 @Autowired
	  private VaccinationCenterService vaccinationCenterService;

	  @GetMapping("/{id}")
	  public VaccinationCenter findVaccinationCenter(@PathVariable long id) {
	    return vaccinationCenterService.getVaccinationCenterById(id);
	  }
	  @DeleteMapping("/{id}")
	  public boolean deleteVaccinationCenter(@PathVariable long id) {
	    return vaccinationCenterService.delete(id);
	  }

	  @GetMapping()
	  public List<VaccinationCenter> findVaccinationCenters() {
	    return vaccinationCenterService.getVaccinationCenters();
	  }

	  @PostMapping
	  public VaccinationCenter addNewVaccinationCenter(@Valid @RequestBody VaccinationCenterDto vaccinationCenterDto) {

	    VaccinationCenter vaccinationCenter = new VaccinationCenter();
	    vaccinationCenter.setName(vaccinationCenterDto.getName());
	    vaccinationCenter.setAddress(vaccinationCenterDto.getCity());
	    return vaccinationCenterService.add_Or_updateCenter(vaccinationCenter);
	  }

	  @PutMapping
	  public VaccinationCenter updateVaccinationCenter(@Valid @RequestBody VaccinationCenterDto vaccinationCenterDto) {
	    VaccinationCenter vaccinationCenter = vaccinationCenterService.
	        getVaccinationCenterById(vaccinationCenterDto.getId());
	    vaccinationCenter.setName(vaccinationCenterDto.getName());
	    vaccinationCenter.setAddress(vaccinationCenterDto.getCity());
	    return vaccinationCenterService.add_Or_updateCenter(vaccinationCenter);
	  }
}
