package com.sv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.dao.LoginDao;
import com.sv.entity.LoginEntity;
import com.sv.utils.ResponseWrapper;

@Service
public class LoginService {

	@Autowired
	private LoginDao logindao;

	@Transactional
	public ResponseWrapper authenticate(LoginEntity loginEntity) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
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
}
