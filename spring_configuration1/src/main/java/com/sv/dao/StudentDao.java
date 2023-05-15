package com.sv.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sv.entity.StudentInfo;
import com.sv.utils.SearchFormDTO;

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
			Query query = session.createQuery("from StudentInfo s where s.username=:username");
			query.setParameter("username", username);
			List<Object> studentList = query.getResultList();
			if (!studentList.isEmpty()) {
				studentInfo = (StudentInfo) studentList.get(0);
			}
			System.out.println("===student info from database === " + studentInfo);
			return studentInfo;
		}
		return studentInfo;
	}

	public Serializable addStudentInfo(StudentInfo studentInfo) {
		Session session = factory.getCurrentSession();
		Serializable serializable = null;
		try {
			serializable = session.save(studentInfo);
			System.out.println("StudentInfo saved inside the database successfully" + studentInfo);
			return serializable;
		} catch (Exception e) {
			System.out.println("Some Exception Occured While Saving StudentInfo:" + e.getMessage());
			return null;
		}

	}

	public List<Object> getAllStudentInfoList() {
		Session session = factory.getCurrentSession();
		try {

			Query query = session.createQuery("from StudentInfo s order by s.studentclass");
			List<Object> studentListFromdb = query.getResultList();
			System.out.println("====Total Number of Student Load from data base " + studentListFromdb.size());
			return studentListFromdb;

		} catch (Exception e) {
			System.out.println("Some Exception Occured While Fetching Student List From Database:" + e.getMessage());
			return null;
		}
	}

	public List<Object> getAllStudentInfoForSearchCriteria(SearchFormDTO searchFormDTO) {

		try {
			StringBuilder querBuilder = new StringBuilder("from StudentInfo s  ");
			Map<String, Object> map = null;

			if (searchFormDTO.getName() != null || searchFormDTO.getStudentclass() != null
					|| searchFormDTO.getUsername() != null) {
				map = new LinkedHashMap<>();
				querBuilder.append(" where ");
				if (searchFormDTO.getName() != null) {
					querBuilder.append("s.name=:name");
					map.put("name", searchFormDTO.getName());
				}
				if (searchFormDTO.getStudentclass() != null) {
					querBuilder.append("s.studentclass=:studentclass");
					map.put("studentclass", searchFormDTO.getStudentclass());
				}
				if (searchFormDTO.getUsername() != null) {
					querBuilder.append("s.username=:username");
					map.put("username", searchFormDTO.getUsername());
				}
			}
			if(searchFormDTO.getSelectedColumnsValue().length>=1 )
			{
				querBuilder.append(" order by ");
				for(int i=0; i<searchFormDTO.getSelectedColumnsValue().length;i++)
				{
					if(i==(searchFormDTO.getSelectedColumnsValue().length-1))
					{
						querBuilder.append(searchFormDTO.getSelectedColumnsValue()[i]);
				    }else
				    {
				    	querBuilder.append(searchFormDTO.getSelectedColumnsValue()[i] +" ,");
				    }
				}
			}
			Session session = factory.getCurrentSession();
			Query query = session.createQuery(querBuilder.toString());

			for (String key : map.keySet()) {
				query.setParameter(key, map.get(key));
			}
			List<Object> studentListFromdb = query.getResultList();
			System.out.println("====Total Number of Student Load from data base " + studentListFromdb.size());
			return studentListFromdb;

		} catch (Exception e) {
			System.out.println("Some Exception Occured While Fetching Student List From Database:" + e.getMessage());
			return null;
		}
	}

	public StudentInfo getStudentDetails(Integer rollNo, String username) {
		StudentInfo studentInfo = null;
		if (username != null && rollNo!=null) {
			Session session = factory.getCurrentSession();
			Query query = session.createQuery("from StudentInfo s where s.username=:username and s.rollNo=:rollNo");
			query.setParameter("username", username);
			query.setParameter("rollNo", rollNo);
			List<Object> studentList = query.getResultList();
			if (!studentList.isEmpty()) {
				studentInfo = (StudentInfo) studentList.get(0);
			}
			System.out.println("===student info from database === " + studentInfo);
			return studentInfo;
		}
		return studentInfo;
	}
	
	
	public Integer deleteStudentDetails(Integer rollNo, String username) {
		if (username != null && rollNo != null) {
			Session session = factory.getCurrentSession();
			Query query = session
					.createQuery("delete from StudentInfo s where s.username=:username and s.rollNo=:rollNo");
			query.setParameter("username", username);
			query.setParameter("rollNo", rollNo);
			int res = query.executeUpdate();
			System.out.println("===delete student info from database for rollno  === " + rollNo);
			return res;
		}
		return 0;
	}
	
	public Integer updateStudentDetails(StudentInfo studentInfo) {
		Session session = factory.getCurrentSession();
		try {
			StudentInfo studentInfoFromDb= getStudentDetailsForRollNo(studentInfo.getRollNo());
			if(studentInfoFromDb!=null)
			{
			    studentInfoFromDb.setName(studentInfo.getName());
				studentInfoFromDb.setFathername(studentInfo.getFathername());
				studentInfoFromDb.setUsername(studentInfo.getUsername());
				studentInfoFromDb.setStudentclass(studentInfo.getStudentclass());
				studentInfoFromDb.setAge(studentInfo.getAge());
				studentInfoFromDb.setAddress(studentInfo.getAddress());
				studentInfoFromDb.setPhoneno(studentInfo.getPhoneno());
				studentInfoFromDb.setDateofbirth(studentInfo.getDateofbirth());;
				studentInfoFromDb.setDateofaddmission(studentInfo.getDateofaddmission());;
				session.update(studentInfoFromDb);
			}
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	
	public StudentInfo getStudentDetailsForRollNo(Integer rollNo) {
		StudentInfo studentInfo = null;
		if (rollNo != null) {
			Session session = factory.getCurrentSession();
			Query query = session.createQuery("from StudentInfo s where  s.rollNo=:rollNo");
			query.setParameter("rollNo", rollNo);
			List<Object> studentList = query.getResultList();
			if (!studentList.isEmpty()) {
				studentInfo = (StudentInfo) studentList.get(0);
			}
			System.out.println("===student info from database === " + studentInfo);
			return studentInfo;
		}
		return studentInfo;
	}
}
