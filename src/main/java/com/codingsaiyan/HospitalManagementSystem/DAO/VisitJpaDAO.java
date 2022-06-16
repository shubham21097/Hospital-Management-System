package com.codingsaiyan.HospitalManagementSystem.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingsaiyan.HospitalManagementSystem.Entity.Visit;

public interface VisitJpaDAO extends JpaRepository<Visit, Integer> {

}
