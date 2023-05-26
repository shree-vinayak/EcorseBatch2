package com.sv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "DISEASES_NAMES")
@Entity
public class DISEASES_NAMES {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "DISEASE_NAME")
	private String disease_name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisease_name() {
		return disease_name;
	}

	public void setDisease_name(String disease_name) {
		this.disease_name = disease_name;
	}

}
