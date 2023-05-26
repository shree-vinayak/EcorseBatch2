package com.sv.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patient_Revisit")
public class Patient_Revisit {

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "DISEASES")
	private String diseases;

	@Column(name = "REVISITDATE")
	private LocalDateTime revisitdate;

	@Column(name = "REGIS_NUMBER")
	private String regis_number;

	@Column(name = "DOCTORS")
	private String doctors;

	@Column(name = "REFER")
	private String refer;

	@Column(name = "ROOMNO")
	private String roomno;

	@Column(name = "ENTRYBY")
	private String entryby;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDiseases() {
		return diseases;
	}

	public void setDiseases(String diseases) {
		this.diseases = diseases;
	}

	public LocalDateTime getRevisitdate() {
		return revisitdate;
	}

	public void setRevisitdate(LocalDateTime revisitdate) {
		this.revisitdate = revisitdate;
	}

	public String getRegis_number() {
		return regis_number;
	}

	public void setRegis_number(String regis_number) {
		this.regis_number = regis_number;
	}

	public String getDoctors() {
		return doctors;
	}

	public void setDoctors(String doctors) {
		this.doctors = doctors;
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

	public String getEntryby() {
		return entryby;
	}

	public void setEntryby(String entryby) {
		this.entryby = entryby;
	}

}
