package com.sv.utils;

public class ResponseWrapper {

	private Object data;
	private String message;
	private boolean status;
	private String token;
	
	
	public ResponseWrapper() {
		super();
	}

	public ResponseWrapper(Object data, String message, boolean status) {
		super();
		this.data = data;
		this.message = message;
		this.status = status;
	}
	
	

	public ResponseWrapper(Object data, String message, boolean status, String token) {
		super();
		this.data = data;
		this.message = message;
		this.status = status;
		this.token = token;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	

}
