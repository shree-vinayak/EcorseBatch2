package com.sv.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sv.entity.LoginEntity;

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
}
