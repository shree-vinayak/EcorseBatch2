package com.sv.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.dao.LoginDao;
import com.sv.dao.StudentDao;
import com.sv.entity.LoginEntity;
import com.sv.entity.StudentInfo;
import com.sv.utils.ResponseWrapper;
import com.sv.utils.SearchFormDTO;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private LoginDao logindao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Transactional
	public ResponseWrapper saveStudentInfo(StudentInfo studentInfo) {
		ResponseWrapper wrapper = new ResponseWrapper();
		if (!isUsernameExits(studentInfo.getUsername())) {

			LoginEntity entity = new LoginEntity(studentInfo.getUsername(), encoder.encode(studentInfo.getPassword()),
					"STUDENT");

			Serializable value = logindao.save(entity);
			if (value != null) {
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
	public Object deleteStudentDetails(Integer rollNo, String username) {
		ResponseWrapper wrapper = null;
		Integer count = studentDao.deleteStudentDetails(rollNo, username);
		if (count > 0) {
			wrapper = new ResponseWrapper(null,
					"Student Detail For RollNo : " + rollNo + " And Username : " + username + " Delete Successfully.",
					true);
		} else {
			wrapper = new ResponseWrapper(null, "Can Not Delete Student Details", false);
		}
		return wrapper;
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

	@Transactional
	public Object getStudentInfoForPassedCriteria(SearchFormDTO searchFormDTO) {
		ResponseWrapper wrapper = null;
		List<Object> studentInfoListFromDb = studentDao.getAllStudentInfoForSearchCriteria(searchFormDTO);
		if (!studentInfoListFromDb.isEmpty()) {
			wrapper = new ResponseWrapper(studentInfoListFromDb, "Fetch Student List Successfully", true);
		} else {
			wrapper = new ResponseWrapper(null, "No Data Found", false);
		}
		return wrapper;
	}

	@Transactional
	public Object getStudentDetails(Integer rollNo, String username) {
		ResponseWrapper wrapper = null;
		StudentInfo studentInfoListFromDb = studentDao.getStudentDetails(rollNo, username);
		if (studentInfoListFromDb != null) {
			wrapper = new ResponseWrapper(studentInfoListFromDb, "Fetch Student Details Successfully", true);
		} else {
			wrapper = new ResponseWrapper(null, "No Data Found", false);
		}
		return wrapper;
	}

	@Transactional
	public Object updateStudentInfo(StudentInfo studentInfo) {
		ResponseWrapper wrapper = null;
		Integer count = studentDao.updateStudentDetails(studentInfo);
		if (count > 0) {
			wrapper = new ResponseWrapper(null, "Student Detail For RollNo : " + studentInfo.getRollNo()
					+ " And Username : " + studentInfo.getUsername() + " Updated Successfully.", true);
		} else {
			wrapper = new ResponseWrapper(null, "Can Not Update Student Details", false);
		}
		return wrapper;
	}

	public Object getClassesList() {
		List<Integer> classlist = new ArrayList<>();
		classlist.add(1);
		classlist.add(2);
		classlist.add(3);
		classlist.add(4);
		classlist.add(5);
		classlist.add(6);
		classlist.add(7);
		classlist.add(8);
		classlist.add(9);
		classlist.add(10);
		classlist.add(11);
		classlist.add(12);
		return classlist;

	}

	@Transactional
	public Object getStudentDetailsForClass(Integer studentclass) {
		ResponseWrapper wrapper = null;
		List<Object> studentInfoListFromDb = studentDao.getAllStudentInfoForStudentClass(studentclass);
		if (!studentInfoListFromDb.isEmpty()) {
			wrapper = new ResponseWrapper(studentInfoListFromDb, "Fetch Student List Successfully", true);
		} else {
			wrapper = new ResponseWrapper(null, "No Data Found", false);
		}
		return wrapper;
	}

}
