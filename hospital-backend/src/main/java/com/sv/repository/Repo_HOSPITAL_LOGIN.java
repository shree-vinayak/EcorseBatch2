package com.sv.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sv.entity.HOSPITAL_LOGIN;


@Repository
public interface Repo_HOSPITAL_LOGIN extends JpaRepository<HOSPITAL_LOGIN, String> {


	
	@Query("select s from HOSPITAL_LOGIN s where s.loginid=(:loginid) and s.status='0'")
	HOSPITAL_LOGIN getUserByLoginidEntered(@Param("loginid") String loginid);
	
	HOSPITAL_LOGIN findByLoginid(String userid);
	
	@Transactional
	@Modifying
	@Query("update HOSPITAL_LOGIN set password=(:newpassword) where loginid=(:loginid)")
	int updatePassword(@Param("loginid") String loginid, @Param("newpassword") String newpassword);

}
