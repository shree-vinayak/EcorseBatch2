package com.sv.utils;

public class SearchFormDTO {

	private String name;
	private String username;
	private Integer studentclass;
	private String[] selectedColumnsValue;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String[] getSelectedColumnsValue() {
		return selectedColumnsValue;
	}

	public void setSelectedColumnsValue(String[] selectedColumnsValue) {
		this.selectedColumnsValue = selectedColumnsValue;
	}
	
	
	

}
