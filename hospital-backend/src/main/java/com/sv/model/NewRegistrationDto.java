package com.sv.model;

import java.time.LocalDateTime;

public class NewRegistrationDto {

	private String regis_number;
	private String name;
	private String fname;
	private LocalDateTime regisration_date;
	private String mobileno;
	private String age;
	private String gender;
	private String cast;
	private String scheme;
	private String doctors;
	private String address;
	private String refer;
	private String roomno;
	private String patientdiseases;
	private LocalDateTime validtill;
	private String entryby;

	public String getRegis_number() {
		return regis_number;
	}

	public void setRegis_number(String regis_number) {
		this.regis_number = regis_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public LocalDateTime getRegisration_date() {
		return regisration_date;
	}

	public void setRegisration_date(LocalDateTime regisration_date) {
		this.regisration_date = regisration_date;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getDoctors() {
		return doctors;
	}

	public void setDoctors(String doctors) {
		this.doctors = doctors;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRefer() {
		return refer;
	}

	public void setRefer(String refer) {
		this.refer = refer;
	}

	public String getRoomno() {
		return roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}

	public String getPatientdiseases() {
		return patientdiseases;
	}

	public void setPatientdiseases(String patientdiseases) {
		this.patientdiseases = patientdiseases;
	}

	public LocalDateTime getValidtill() {
		return validtill;
	}

	public void setValidtill(LocalDateTime validtill) {
		this.validtill = validtill;
	}

	public String getEntryby() {
		return entryby;
	}

	public void setEntryby(String entryby) {
		this.entryby = entryby;
	}
	
	
}
