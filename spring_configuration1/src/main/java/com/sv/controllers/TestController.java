package com.sv.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sv.entity.User;

@Controller
public class TestController {

	@GetMapping("test")
	@ResponseBody
	public Object helloWorld() {
		List<User> userList = new ArrayList<>();
		userList.add(new User("Harsh", 14l));
		userList.add(new User("Ankit", 27l));
		userList.add(new User("Rajat", 23l));

		return userList;
	}
}
