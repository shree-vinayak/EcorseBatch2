package com.sv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sv.entity.UserData;
import com.sv.service.UserDataService;

@RestController
public class UserController {

	@Autowired
	private UserDataService userDataService;

	@GetMapping(value = "getdata", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object listUser() {
		List<UserData> theCustomers = userDataService.getUserData();
		return theCustomers;
	}

	@PostMapping(value = "saveuser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveUser(@RequestBody UserData userdata) {
		System.out.println(userdata);
		return "Saved Successfully.";
	}

	@PutMapping(value = "updateuser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateUser(@RequestBody UserData userdata) {
		System.out.println(userdata);
		return "Updated Successfully";
	}

	@DeleteMapping(value = "delete")
	public String deleteUser(@RequestParam("name") String name) {
		System.out.println(name);
		return "User Deleted For Name: " + name;
	}
}
