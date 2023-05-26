package com.sv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "HOSPITAL_LOGIN")
public class HOSPITAL_LOGIN {

	@Id
	@Column(name = "LOGINID")
	private String loginid;

	@Column(name = "PASSWORD")
	private String password;

	
	@Column(name = "MOBILE_NO")
	private String mobile_no;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "STATUS")
	private String status;

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public static void main(String[] args) {
		
		BCryptPasswordEncoder b = new BCryptPasswordEncoder(); 
	  System.out.println(	b.encode("abc@123"));;
	}

}
