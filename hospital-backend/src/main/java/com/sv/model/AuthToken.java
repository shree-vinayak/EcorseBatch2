package com.sv.model;

public class AuthToken {

	private String token;
	private String loginid;
	private String role;
	private String status;

	private boolean flag;
	private String msg;

	public AuthToken() {
		super();
	}

	public AuthToken(String token, String loginid, String role, String status, boolean flag, String msg) {
		super();
		this.token = token;
		this.loginid = loginid;
		this.role = role;
		this.status = status;
		this.flag = flag;
		this.msg = msg;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
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

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
