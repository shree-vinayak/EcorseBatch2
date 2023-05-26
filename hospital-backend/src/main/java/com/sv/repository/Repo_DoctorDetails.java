package com.sv.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sv.entity.DoctorDetails;

@Repository
public interface Repo_DoctorDetails  extends JpaRepository<DoctorDetails, Integer>{

	@Query(value = "select max(doctorid) from doctordetails", nativeQuery = true)
	public Integer getMaxDoctorId();
	
	@Transactional
	@Modifying
	@Query(value = "delete from doctordetails  where  doctorid=:doctorid", nativeQuery = true)
	public int deleteDoctor(Integer doctorid);

}
