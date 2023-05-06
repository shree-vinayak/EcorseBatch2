package com.sv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sv.entity.StudentInfo;
import com.sv.service.StudentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentInfoController {

	@Autowired
	private StudentService studentService;

	@PostMapping(value = "/saveStudentInfo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object saveStudentInfo(@RequestBody StudentInfo studentInfo) {

		return studentService.saveStudentInfo(studentInfo);

	}

}
