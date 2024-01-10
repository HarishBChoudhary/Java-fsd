package com.ty.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.entity.VaccinationCenter;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Long>{

}
