package com.sv.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sv.entity.NewRegistration;

@Repository
public interface Repo_NewRegistration extends JpaRepository<NewRegistration, Long> {

	
	@Query("select s from NewRegistration s where s.regis_number=(:regis_number) ")
	NewRegistration getPatientDetails(String regis_number);

	@Query("select count(s),s.doctors from NewRegistration s where "
			+ "s.regisration_date>=(:startdate) and regisration_date<=(:enddate) group by s.doctors")
	List<Object[]> getDoctorWiseCount(LocalDateTime startdate, LocalDateTime enddate);

	@Query("select s from NewRegistration s where "
			+ "s.regisration_date>=(:startdate) and regisration_date<=(:enddate)  and s.doctors=(:doctors) ")
	List<NewRegistration> getNewRegistrationDetails(LocalDateTime startdate, LocalDateTime enddate,
			String doctors);


}
