package com.sv.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.dao.LoginDao;
import com.sv.dao.StudentDao;
import com.sv.entity.LoginEntity;
import com.sv.entity.StudentInfo;
import com.sv.utils.ResponseWrapper;

@Service
public class LoginService {

	@Autowired
	private LoginDao logindao;
	
	@Autowired
	private StudentDao studentDao;
	

	@Transactional
	public ResponseWrapper authenticate(LoginEntity loginEntity, boolean logintype) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		if(logintype)
		{
		  teacherLogin(loginEntity,responseWrapper);
		}
		else
		{
			studentLogin(loginEntity, responseWrapper);
		}
		
		return responseWrapper;

	}
	
	public ResponseWrapper teacherLogin(LoginEntity loginEntity,ResponseWrapper responseWrapper)
	{
		try {
			LoginEntity loginEntityFromDb = logindao.getLoginEntityById(loginEntity.getUsername());
			if (loginEntityFromDb != null && loginEntityFromDb.getPassword().equals(loginEntity.getPassword())) {
				responseWrapper.setData(loginEntityFromDb);
				responseWrapper.setMessage("Authenticate Successfully.");
				responseWrapper.setStatus(true);
			} else {
				responseWrapper.setData(null);
				responseWrapper.setMessage("Can Not Authenticate, Invalid Username And Password.");
				responseWrapper.setStatus(false);
			}
		} catch (Exception e) {
			responseWrapper.setData(null);
			responseWrapper.setMessage("Can Not Authenticate, Invalid Username And Password.");
			responseWrapper.setStatus(false);

			System.out.println("=== Some Exception Occurred during authenticate user=====");

		}
		return responseWrapper;
	}
	
	public ResponseWrapper studentLogin(LoginEntity loginEntity, ResponseWrapper wrapper)
	{
		try {
			StudentInfo studentInfoFromDb = studentDao.getStudentoInfoUsername(loginEntity.getUsername());
			if (studentInfoFromDb != null && studentInfoFromDb.getPassword().equals(loginEntity.getPassword())) {
				wrapper.setData(studentInfoFromDb);
				wrapper.setMessage("Authenticate Successfully.");
				wrapper.setStatus(true);
			} else {
				wrapper.setData(null);
				wrapper.setMessage("Can Not Authenticate, Invalid Username And Password.");
				wrapper.setStatus(false);
			}
		} catch (Exception e) {
			wrapper.setData(null);
			wrapper.setMessage("Can Not Authenticate, Invalid Username And Password.");
			wrapper.setStatus(false);

			System.out.println("=== Some Exception Occurred during authenticate user=====");

		}
		return wrapper;
	}
}
