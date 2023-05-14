package com.sv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sv.entity.DISEASES_NAMES;

@Repository
public interface Repo_DISEASES_NAMES  extends JpaRepository<DISEASES_NAMES, String >{

	@Query("select s from DISEASES_NAMES s order by s.id")
	List<DISEASES_NAMES> getAllDiseases();



}
