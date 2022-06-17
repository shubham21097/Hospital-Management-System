package com.codingsaiyan.HospitalManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingsaiyan.HospitalManagementSystem.DAO.PatientJpaDAO;
import com.codingsaiyan.HospitalManagementSystem.DAO.VisitJpaDAO;
import com.codingsaiyan.HospitalManagementSystem.Entity.Patient;
import com.codingsaiyan.HospitalManagementSystem.Entity.Visit;

@RestController
public class VisitRestController {

	
	@Autowired
	private PatientJpaDAO patientJpaDAO;
	
	@Autowired
	private VisitJpaDAO visitJpaDAO;
	
	@GetMapping("/visits")
	public List<Visit> getAllVisits() {
		return visitJpaDAO.findAll();
	}
	
	@GetMapping("/visits/{id}")
	public Visit getVisitById(@PathVariable int id) {
		Optional<Visit> opVisit = visitJpaDAO.findById(id);
		if(!opVisit.isPresent()) {
			throw new RuntimeException("Visit record not found...");
		}
		return opVisit.get();
	}
	
	@GetMapping("/patients/{id}/visits")
	public List<Visit> getAllVisitsByPatientId(@PathVariable int id){
		Optional<Patient> patient = patientJpaDAO.findById(id);
		if(!patient.isPresent()) {
			throw new RuntimeException("Patient not found..");
		}
		return patient.get().getVisits();
	}
		
	@PostMapping("/visits/patients/{id}")
	public ResponseEntity<Visit> createVisit(@RequestBody Visit visit, @PathVariable int id) {
		Optional<Patient> patient = patientJpaDAO.findById(id);
		if(!patient.isPresent()) {
			throw new RuntimeException("Patient not found..");
		}
		visit.setVisitId(0);
		visit.setPatient(patient.get());
		Visit vs = visitJpaDAO.save(visit);
		return new ResponseEntity<>(vs, HttpStatus.CREATED);
	}
}
