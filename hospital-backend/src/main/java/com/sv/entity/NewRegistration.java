package com.sv.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NEWREGISTRATION")
public class NewRegistration {

	@Id
	@Column(name = "REGIS_NUMBER")
	private String regis_number;

	@Column(name = "NAME")
	private String name;

	@Column(name = "FNAME")
	private String fname;

	@Column(name = "REGISRATION_DATE")
	private LocalDateTime regisration_date;

	@Column(name = "MOBILENO")
	private String mobileno;

	@Column(name = "AGE")
	private String age;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "CAST")
	private String cast;

	@Column(name = "SCHEME")
	private String scheme;

	@Column(name = "DOCTORS")
	private String doctors;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "REFER")
	private String refer;

	@Column(name = "ROOMNO")
	private String roomno;

	@Column(name = "PATIENTDISEASES")
	@Convert(converter = ListToStringConverter.class)
	private List<String> patientdiseases;

	@Column(name = "VALIDTILL")
	private LocalDateTime validtill;

	@Column(name = "ENTRYBY")
	private String entryby;

	
	@Column(name = "AADHARNUMBER")
	private String aadharnumber;
	
	
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

	public String getRegis_number() {
		return regis_number;
	}

	public void setRegis_number(String regis_number) {
		this.regis_number = regis_number;
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

	public List<String> getPatientdiseases() {
		return patientdiseases;
	}

	public void setPatientdiseases(List<String> patientdiseases) {
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

	public String getAadharnumber() {
		return aadharnumber;
	}

	public void setAadharnumber(String aadharnumber) {
		this.aadharnumber = aadharnumber;
	}

	@Override
	public String toString() {
		return "NewRegistration [regis_number=" + regis_number + ", name=" + name + ", fname=" + fname
				+ ", regisration_date=" + regisration_date + ", mobileno=" + mobileno + ", age=" + age + ", gender="
				+ gender + ", cast=" + cast + ", scheme=" + scheme + ", doctors=" + doctors + ", address=" + address
				+ ", refer=" + refer + ", roomno=" + roomno + ", patientdiseases=" + patientdiseases + ", validtill="
				+ validtill + ", entryby=" + entryby + ", aadharnumber=" + aadharnumber + "]";
	}
	

}
