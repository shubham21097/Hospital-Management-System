package com.codingsaiyan.HospitalManagementSystem.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "visit")
public class Visit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int visitId;
	private String dateTime;
	//private int patientId;
	private String staffId;
	private String symptoms;
	private String diagnosis;
	private int roomId;
	private String prescription;
	private int invoiceId;
	
	@ManyToOne(cascade = {CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "patientId")
	private Patient patient;
	
	public Visit() {
		
	}
	
	

	public Visit(String dateTime, String staffId, String symptoms, String diagnosis, int roomId, String prescription,
			int invoiceId, Patient patient) {
		super();
		this.dateTime = dateTime;
		this.staffId = staffId;
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.roomId = roomId;
		this.prescription = prescription;
		this.invoiceId = invoiceId;
		this.patient = patient;
	}



	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
	
}
