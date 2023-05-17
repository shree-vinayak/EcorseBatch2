package com.sv.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sv.entity.Marks;
import com.sv.entity.StudentInfo;

@Repository
public class MarskDaoo {
	
	@Autowired
	private SessionFactory factory;
	

	@Autowired
	private StudentDao studentDao;


	public List<Object> getAllStudentResult(String username) {
		if (username!=null) {
			Session session = factory.getCurrentSession();
			Query query = session.createQuery("from Marks s where s.username=:username ");
			query.setParameter("username", username);
			List<Object> studentList = query.getResultList();
			
			System.out.println("===student info from database === " + studentList);
			return studentList;
		}
		return null;
	}


	public Serializable addStudentMarks(Marks marks) {
		StudentInfo studentInfo=studentDao.getStudentoInfoUsername(marks.getUsername());
		marks.setRollno(studentInfo.getRollNo());
		
		Session session = factory.getCurrentSession();
		Serializable serializable = null;
		try {
			serializable = session.save(marks);
			System.out.println("StudentResult  saved inside the database successfully" + studentInfo);
			return serializable;
		} catch (Exception e) {
			System.out.println("Some Exception Occured While Saving StudentResult :" + e.getMessage());
			return null;
		}

	}

}
