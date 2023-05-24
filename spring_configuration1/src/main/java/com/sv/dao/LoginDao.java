package com.sv.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sv.entity.LoginEntity;
import com.sv.entity.Marks;
import com.sv.entity.StudentInfo;

@Repository
public class LoginDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public LoginEntity getLoginEntityById(String username) {
		Session session = sessionFactory.getCurrentSession();
		LoginEntity loginEntity = (LoginEntity) session.get(LoginEntity.class, username);
		System.out.println("===loginEntity loaded successfully, loginEntity details=== " + loginEntity);
		return loginEntity;

	}

	public Serializable save(LoginEntity entity) {
		Session session = sessionFactory.getCurrentSession();
		Serializable serializable = null;
		try {
			serializable = session.save(entity);
			System.out.println("Details saved inside the login table" + serializable);
			return serializable;
		} catch (Exception e) {
			System.out.println("Some Exception Occured While Saving login details :" + e.getMessage());
			return null;
		}
		
	}
	
}
