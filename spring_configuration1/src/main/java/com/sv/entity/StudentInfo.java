package com.sv.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studentinfo")
public class StudentInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rollNo")
	private Integer rollNo;

	@Column(name = "name")
	private String name;

	@Column(name = "fathername")
	private String fathername;

	@Column(name = "role")
	private String role;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "studentclass")
	private Integer studentclass;

	@Column(name = "age")
	private Integer age;

	@Column(name = "address")
	private String address;

	@Column(name = "phoneno")
	private String phoneno;

	@Column(name = "dateofbirth")
	private LocalDate dateofbirth;

	@Column(name = "dateofaddmission")
	private LocalDate dateofaddmission;

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getStudentclass() {
		return studentclass;
	}

	public void setStudentclass(Integer studentclass) {
		this.studentclass = studentclass;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public LocalDate getDateofaddmission() {
		return dateofaddmission;
	}

	public void setDateofaddmission(LocalDate dateofaddmission) {
		this.dateofaddmission = dateofaddmission;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "StudentInfo [rollNo=" + rollNo + ", name=" + name + ", fathername=" + fathername + ", role=" + role
				+ ", username=" + username + ", password=" + password + ", studentclass=" + studentclass + ", age="
				+ age + ", address=" + address + ", phoneno=" + phoneno + ", dateofbirth=" + dateofbirth
				+ ", dateofaddmission=" + dateofaddmission + "]";
	}

}
