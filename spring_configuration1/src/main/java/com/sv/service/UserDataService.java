package com.sv.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.dao.LoginDao;
import com.sv.dao.UserDataDao;
import com.sv.entity.LoginEntity;
import com.sv.entity.UserData;

@Service
public class UserDataService  {

	
	@Autowired
	private UserDataDao userDataDao; 
	
	

	@Autowired
	private LoginDao logindao;
	

	@Transactional
	public List<UserData> getUserData() {
		return userDataDao.getUserData();
	}
	
}
