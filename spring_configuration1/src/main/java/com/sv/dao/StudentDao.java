package com.sv.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sv.entity.StudentInfo;

@Repository
public class StudentDao {

	@Autowired
	private SessionFactory factory;

	/**
	 * This method is used to fetch the StudentInfo from the database for passed
	 * username
	 * 
	 * @param username
	 * @return StudentInfo Object for passed username, And null if no details found
	 *         inside the database or if username is null
	 */
	public StudentInfo getStudentoInfoUsername(String username) {
		StudentInfo studentInfo = null;
		if (username != null) {
			Session session = factory.getCurrentSession();
			Query query=session.createQuery("from StudentInfo s where s.username=:username");  
			query.setParameter("username",username);  
			List<Object> studentList= query.getResultList();
			if(!studentList.isEmpty())
			{
				studentInfo=(StudentInfo) studentList.get(0);	
			}
			System.out.println("===student info from database === " + studentInfo);
			return studentInfo;
		}
		return studentInfo;
	}
	
	
	public Serializable addStudentInfo(StudentInfo studentInfo) {
		Session session = factory.getCurrentSession();
		 Serializable serializable=null;
		try {
		    serializable=	session.save(studentInfo);
			System.out.println("StudentInfo saved inside the database successfully" + studentInfo);
			return serializable;
		} catch (Exception e) {
			System.out.println("Some Exception Occured While Saving StudentInfo:" + e.getMessage());
			return null;
		}

	}


	public List<Object> getAllStudentInfoList() {
		Session session =factory.getCurrentSession(); 
		try {
			
			Query query= session.createQuery("from StudentInfo s order by s.studentclass"); 
			List<Object> studentListFromdb= query.getResultList(); 
			System.out.println("====Total Number of Student Load from data base "+studentListFromdb.size());
			return  studentListFromdb;
			
		} catch (Exception e) {
			System.out.println("Some Exception Occured While Fetching Student List From Database:" + e.getMessage());
			return null;
		}
	}
}
