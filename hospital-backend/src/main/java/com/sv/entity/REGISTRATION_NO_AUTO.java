package com.sv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REGISTRATION_NO_AUTO")
public class REGISTRATION_NO_AUTO {

	@Id
	@Column(name = "YEAR")
	private String year;

	@Column(name = "COUNT")
	private String count;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
