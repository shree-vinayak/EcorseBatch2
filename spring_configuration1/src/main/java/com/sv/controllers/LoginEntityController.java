package com.sv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sv.entity.LoginEntity;
import com.sv.service.LoginService;
import com.sv.utils.ResponseWrapper;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginEntityController {

	@Autowired
	private LoginService loginservice;

	@PostMapping(name = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseWrapper authenticateTeacher(@RequestBody LoginEntity loginEntity,
			@RequestParam("logintype")boolean logintype) {
		return loginservice.authenticate(loginEntity,logintype);
	}
}
