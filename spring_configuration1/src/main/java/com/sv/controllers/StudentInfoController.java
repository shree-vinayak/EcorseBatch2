package com.sv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sv.entity.StudentInfo;
import com.sv.service.StudentService;
import com.sv.utils.SearchFormDTO;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentInfoController {

	@Autowired
	private StudentService studentService;

	@PostMapping(value = "/saveStudentInfo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object saveStudentInfo(@RequestBody StudentInfo studentInfo) {

		return studentService.saveStudentInfo(studentInfo);

	}
	
	@GetMapping(value="/getAllStudentInfo",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object getAllStudentInfo()
	{
		return studentService.getAllStudentInfoFromService();
	}
	
	
	
	@PostMapping(value = "/getStuInfoForSearchCriteria", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getStuInfoForSearchCriteria(@RequestBody SearchFormDTO searchFormDTO) {

		return studentService.getStudentInfoForPassedCriteria(searchFormDTO);

	}
	
	
	@GetMapping(value = "/getStudentDetails",  produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getStudentDetails(@RequestParam("rollno")Integer rollNo,
			@RequestParam("username") String username) {
		return studentService.getStudentDetails(rollNo,username);

	}
	
	//This api is used to delete the specific student from the database for rollno
		@DeleteMapping(value = "/deleteStudentDetails", produces = MediaType.APPLICATION_JSON_VALUE)
		public Object deleteStudentDetails(@RequestParam("rollno") Integer rollNo,
				@RequestParam("username") String username) {
			return studentService.deleteStudentDetails(rollNo, username);

		}
		
		@PutMapping(value = "/updateStudentInfo", 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public Object updateStudentInfo(@RequestBody StudentInfo studentInfo) {
			return studentService.updateStudentInfo(studentInfo);
		}
		
		
	
		@GetMapping(value = "/getClassesList",  produces = MediaType.APPLICATION_JSON_VALUE)
		public Object getStudentDetails( ){
			return studentService.getClassesList();
		}
		
		@GetMapping(value = "/getStudentDetailsForClass",  produces = MediaType.APPLICATION_JSON_VALUE)
		public Object getStudentDetailsForClass(@RequestParam("studentclass")Integer   studentclass){
			return studentService.getStudentDetailsForClass(studentclass);
		}
		
		
	

}
