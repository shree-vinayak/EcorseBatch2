package com.sv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sv.entity.Marks;
import com.sv.service.MarksService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class MarksController {
	
	@Autowired
	private MarksService marksService;
	
	
	@GetMapping(value = "/getStudentResult",  produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getStudentResult(
			@RequestParam("username")String   username){
		return marksService.getStudentResult(username);
	}
	
	@PostMapping(value = "/saveStudentResult", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object saveStudentResult(
			@RequestBody Marks    marks){
		return marksService.saveStudentResult(marks);
	}

}
