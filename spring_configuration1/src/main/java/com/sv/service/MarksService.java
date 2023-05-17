package com.sv.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.dao.MarskDaoo;
import com.sv.entity.Marks;
import com.sv.utils.ResponseWrapper;

@Service
public class MarksService {

	@Autowired
	private MarskDaoo marskDaoo;

	@Transactional
	public Object getStudentResult( String username) {
		ResponseWrapper wrapper = null;
		List<Object> studentResultListFromDb = marskDaoo.getAllStudentResult(username);
		if (!studentResultListFromDb.isEmpty()) {
			wrapper = new ResponseWrapper(studentResultListFromDb, "Fetch Student Result List Successfully", true);
		} else {
			wrapper = new ResponseWrapper(null, "No Data Found", false);
		}
		return wrapper;
	}

	@Transactional
	public Object saveStudentResult(Marks marks) {
		ResponseWrapper wrapper =null;
			// implement all the validation and rules for admission in your school. //
		
		try
		{
			Serializable serializable = marskDaoo.addStudentMarks(marks);
			wrapper= new ResponseWrapper(serializable,"Student Result Saved Successfully.",true);
		   
		}catch (Exception e) {
			e.printStackTrace();
			wrapper= new ResponseWrapper(null,"Can not save student result",false);
		}
		
		

		return wrapper;
	}
	
	
}
