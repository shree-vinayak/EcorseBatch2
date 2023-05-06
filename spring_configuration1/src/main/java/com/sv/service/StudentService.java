package com.sv.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.dao.StudentDao;
import com.sv.entity.StudentInfo;
import com.sv.utils.ResponseWrapper;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	@Transactional
	public ResponseWrapper saveStudentInfo(StudentInfo studentInfo) {
		ResponseWrapper wrapper = new ResponseWrapper();
		if (!isUsernameExits(studentInfo.getUsername())) {
			// implement all the validation and rules for admission in your school. //
			System.out.println("=====StudentInfo before saving to database=====" + studentInfo);
			studentInfo.setDateofaddmission(LocalDate.now());
			studentInfo.setRole("STUDENT");
			Serializable serializable = studentDao.addStudentInfo(studentInfo);
			wrapper.setData(serializable);
			wrapper.setMessage("StudentInfo Saved Successfully.");
			wrapper.setStatus(true);
		} else {
			wrapper.setData(null);
			wrapper.setMessage(
					"Can not create studentInfo, because student with this username is already available inside the database.");
			wrapper.setStatus(false);
		}

		return wrapper;
	}

	/**
	 * 
	 * @param username
	 * @return true if StudentInfo object is available inside the database for
	 *         passed username otherwise return false
	 */
	@Transactional
	public boolean isUsernameExits(String username) {
		return studentDao.getStudentoInfoUsername(username) != null ? true : false;
	}

	@Transactional
	public Object getAllStudentInfoFromService() {
		ResponseWrapper wrapper = null;

		List<Object> studentInfoListFromDb = studentDao.getAllStudentInfoList();
		if (!studentInfoListFromDb.isEmpty()) {
			wrapper = new ResponseWrapper(studentInfoListFromDb, "Fetch Student List Successfully", true);
		} else {
			wrapper = new ResponseWrapper(null, "No Data Found", false);
		}
		return wrapper;
	}

}