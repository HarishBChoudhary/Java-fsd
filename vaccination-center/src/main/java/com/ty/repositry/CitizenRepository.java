package com.ty.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.entity.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long>{

	public List<Citizen> findAllByCenterId(long centerId);
}
