package com.sv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sv.entity.REGISTRATION_NO_AUTO;

public interface Repo_REGISTRATION_NO_AUTO extends JpaRepository<REGISTRATION_NO_AUTO, String> {

	@Transactional
	@Modifying
	@Query(value = "update REGISTRATION_NO_AUTO s set s.count=(:count) where s.year=(:currentyear)")
	int updatecount(String count, String currentyear);

}
