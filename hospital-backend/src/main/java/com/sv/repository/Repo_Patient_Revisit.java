package com.sv.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sv.entity.Patient_Revisit;

@Repository
public interface Repo_Patient_Revisit extends JpaRepository<Patient_Revisit, Integer> {

	
	@Transactional
	@Modifying
	@Query(value="insert into Patient_Revisit("
			+ "diseases,revisitdate,regis_number,doctors,refer,roomno,entryby)  values("
			+ ":diseases,:revisitdate,:regis_number,:doctors,:refer,:roomno,:entryby)",nativeQuery = true)
	public int insertRec(
			String diseases,
			LocalDateTime revisitdate,
			String regis_number,
			String doctors,
			String refer,
			String roomno,
			String entryby
				);

	
	@Query("select count(s),s.doctors from Patient_Revisit s where "
			+ "s.revisitdate>=(:startdate) and revisitdate<=(:enddate) group by s.doctors")
	public List<Object[]> getDoctorWiseCount(LocalDateTime startdate, LocalDateTime enddate);


	@Query("select a.diseases,a.revisitdate,a.regis_number,a.doctors,"
			+ "a.refer,a.roomno,a.entryby,b.name,b.fname,"
			+ "b.regisration_date,b.mobileno,b.age,"
			+ "b.gender,b.cast,b.scheme,b.address,"
			+ "b.validtill,a.doctors,b.aadharnumber from Patient_Revisit a inner join  NewRegistration b on a.regis_number=b.regis_number"
			+ " where a.revisitdate>=(:startdate) and a.revisitdate<=(:enddate)  and a.doctors=(:doctors) ")
	public List<Object[]> getAllRevisitPatientDetails(LocalDateTime startdate, LocalDateTime enddate,
			String doctors);
	
	@Query("select a.diseases,a.revisitdate,a.regis_number,a.doctors,"
			+ "a.refer,a.roomno,a.entryby,b.name,b.fname,"
			+ "b.regisration_date,b.mobileno,b.age,"
			+ "b.gender,b.cast,b.scheme,b.address,"
			+ "b.validtill,b.aadharnumber from Patient_Revisit a inner join  NewRegistration b on a.regis_number=b.regis_number"
			+ " where a.revisitdate>=(:startdate) and a.revisitdate<=(:enddate)")
	public List<Object[]> getAllRevisitPatientDetails(LocalDateTime startdate, LocalDateTime enddate);

	
}
