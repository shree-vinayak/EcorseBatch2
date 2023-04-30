package com.sv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.dao.UserDataDao;
import com.sv.entity.UserData;

@Service
public class UserDataService {

	
	@Autowired
	private UserDataDao userDataDao; 
	

	@Transactional
	public List<UserData> getUserData() {
		return userDataDao.getUserData();
	}
}
