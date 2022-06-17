package com.codingsaiyan.HospitalManagementSystem.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codingsaiyan.HospitalManagementSystem.Entity.Patient;

public interface PatientJpaDAO extends JpaRepository<Patient, Integer> {
	
	// method for finding patient by name
	//List<Patient> findByFirstName(String firstName);
	
	@Query("select i from Patient i where i.firstName like %?1%")
	List<Patient> findByFirstNameContaining(String firstName);
	

}
