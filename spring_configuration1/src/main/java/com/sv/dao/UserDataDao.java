package com.sv.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sv.entity.UserData;

@Repository
public class UserDataDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<UserData> getUserData() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UserData");
		return query.getResultList();
	}

}
