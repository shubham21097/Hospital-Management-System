package com.codingsaiyan.HospitalManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingsaiyan.HospitalManagementSystem.DAO.AddressJpaDAO;
import com.codingsaiyan.HospitalManagementSystem.DAO.PatientJpaDAO;
import com.codingsaiyan.HospitalManagementSystem.Entity.Address;
import com.codingsaiyan.HospitalManagementSystem.Entity.Patient;

@RestController
public class AddressRestController {

	@Autowired
	private PatientJpaDAO patientJpaDAO;
	
	@Autowired
	private AddressJpaDAO addressJpaDAO;
	
	@GetMapping("/addresses")
	public List<Address> getAllAddress() {
		return addressJpaDAO.findAll();
	}
	
	@GetMapping("/addresses/patients/{id}")
	public Address getAddressByPatientId(@PathVariable int id) {
		Optional<Patient> opPatient = patientJpaDAO.findById(id);
		if(!opPatient.isPresent()) {
			throw new RuntimeException("Patient not found..");
		}
		return opPatient.get().getAddress();
	}
	
	@GetMapping("/addresses/{id}")
	public Address getAddressByAddressId(@PathVariable int id) {
		Optional<Address> opAddress =  addressJpaDAO.findById(id);
		if(!opAddress.isPresent()) {
			throw new RuntimeException("Address not found..");
		}
		return opAddress.get();
	}
	
	@PostMapping("/addresses/patients/{id}")
	public ResponseEntity<Address> addAddressByPatientId(@RequestBody Address address, @PathVariable int id) {
		Optional<Patient> opPatient = patientJpaDAO.findById(id);
		if(!opPatient.isPresent()) {
			throw new RuntimeException("Patient not found..");
		}
		address.setAddressId(0);
		Address adr = addressJpaDAO.save(address);
		adr.setPatient(opPatient.get());
		return new ResponseEntity<>(adr, HttpStatus.CREATED);
	}
	
	@PutMapping("/addresses/patients/{id}")
	public Address updateAddressByPatientId(@RequestBody Address address, @PathVariable int id) {
		Optional<Patient> opPatient = patientJpaDAO.findById(id);
		if(!opPatient.isPresent()) {
			throw new RuntimeException("Patient not found..");
		}
		Address adr = addressJpaDAO.save(address);
		adr.setPatient(opPatient.get());
		return adr;
	}
	
	@DeleteMapping("/addresses/{id}")
	public String deleteAddressById(@PathVariable int id) {
		Optional<Address> opAddress =  addressJpaDAO.findById(id);
		if(!opAddress.isPresent()) {
			throw new RuntimeException("Address not found..");
		}
		addressJpaDAO.deleteById(id);
		return("Address with id: " + id + " deleted successfully");
	}
}
