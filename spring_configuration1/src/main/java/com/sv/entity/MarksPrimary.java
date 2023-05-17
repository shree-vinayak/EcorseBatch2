package com.sv.entity;

import java.io.Serializable;

public class MarksPrimary implements Serializable {

	private Integer rollno;
	private String username;
	private String examtype;

	

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

}
