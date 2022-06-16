package com.codingsaiyan.HospitalManagementSystem.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="patient_id")
	private int patientId;
	private String firstName;
	private String lastName;
	private String gender;
	
	@OneToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name = "address")
	private Address patientAddress;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "visitId")
	//@JsonIgnore
	private List<Visit> visits;
	
	public Patient(String firstName, String lastName, String gender, Address address, List<Visit> visits) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.patientAddress = address;
		this.visits = visits;
	}
	public Patient() {
		
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Address getAddress() {
		return patientAddress;
	}
	public void setAddress(Address address) {
		this.patientAddress = address;
	}
	public List<Visit> getVisits() {
		return visits;
	}
	public void setVisitId(List<Visit> visits) {
		this.visits = visits;
	}
	
	public void addVisit(Visit v) {
		if(visits == null) {
			visits = new ArrayList<>();
			visits.add(v);
		}
	}
	
}
