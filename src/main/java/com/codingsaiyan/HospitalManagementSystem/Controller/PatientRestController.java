package com.codingsaiyan.HospitalManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingsaiyan.HospitalManagementSystem.DAO.AddressJpaDAO;
import com.codingsaiyan.HospitalManagementSystem.DAO.PatientJpaDAO;
import com.codingsaiyan.HospitalManagementSystem.DAO.VisitJpaDAO;
import com.codingsaiyan.HospitalManagementSystem.Entity.Patient;
import com.codingsaiyan.HospitalManagementSystem.Entity.Visit;

@RestController
public class PatientRestController {

	@Autowired
	private PatientJpaDAO patientJpaDAO;
	
	@Autowired
	private AddressJpaDAO addressJpaDAO;
	
	@Autowired
	private VisitJpaDAO visitJpaDAO;
	
	@GetMapping("/patients")
	public List<Patient> getAllPatients(){
		return patientJpaDAO.findAll();
	}
	
	@GetMapping("/patients/{id}")
	public Patient findPatientById(@PathVariable int id) {
		Optional<Patient> opPatient = patientJpaDAO.findById(id);
		if(!opPatient.isPresent()) {
			throw new RuntimeException("Patient not found..");
		}
		return opPatient.get();
	}
	
	@PostMapping("/patients")
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
		// setting id to 0 so that hibernate will create a new patient instead of
		// updating
		patient.setPatientId(0);
		Patient pt = patientJpaDAO.save(patient);
		return new ResponseEntity<>(pt, HttpStatus.CREATED);
	}
	
	@PutMapping("/patients/{id}")
	public Patient updatePatientById(@PathVariable int id) {
		Optional<Patient> patient = patientJpaDAO.findById(id);
		if(!patient.isPresent()) {
			throw new RuntimeException("Patient not found..");
		}
		Patient pt = patientJpaDAO.save(patient.get());
		return pt;
	}
	
	@PostMapping("/visits/patients/{id}")
	public ResponseEntity<Visit> createVisit(@RequestBody Visit visit, @PathVariable int id) {
		
		visit.setVisitId(0);
		visit.setPatientId(id);
		Visit vs = visitJpaDAO.save(visit);
		return new ResponseEntity<>(vs, HttpStatus.CREATED);
	}
}
