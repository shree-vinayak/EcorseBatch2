package com.sv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="marks")
@IdClass(MarksPrimary.class)
public class Marks {
	
	@Id
	@Column(name="rollno")
	private Integer rollno;
	
	@Id
	@Column(name="username")
	private String username; 
	
	@Id
	@Column(name="examtype")
	private String examtype;

	@Column(name="physicsmarks")
	private Integer physicsmarks; 
	

	@Column(name="chemistrymarks")
	private Integer chemistrymarks; 
	

	@Column(name="mathsmarks")
	private Integer mathsmarks;


	public Integer getRollno() {
		return rollno;
	}


	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getExamtype() {
		return examtype;
	}


	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}


	public Integer getPhysicsmarks() {
		return physicsmarks;
	}


	public void setPhysicsmarks(Integer physicsmarks) {
		this.physicsmarks = physicsmarks;
	}


	public Integer getChemistrymarks() {
		return chemistrymarks;
	}


	public void setChemistrymarks(Integer chemistrymarks) {
		this.chemistrymarks = chemistrymarks;
	}


	public Integer getMathsmarks() {
		return mathsmarks;
	}


	public void setMathsmarks(Integer mathsmarks) {
		this.mathsmarks = mathsmarks;
	}
}
