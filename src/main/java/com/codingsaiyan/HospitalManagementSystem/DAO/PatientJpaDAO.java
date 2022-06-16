package com.codingsaiyan.HospitalManagementSystem.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingsaiyan.HospitalManagementSystem.Entity.Patient;

public interface PatientJpaDAO extends JpaRepository<Patient, Integer> {

}
