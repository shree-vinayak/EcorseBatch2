package com.sv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.entity.DISEASES_NAMES;
import com.sv.repository.Repo_DISEASES_NAMES;

@Service
public class DiseasesNamesService {

	@Autowired
	private Repo_DISEASES_NAMES disease_repo; 
	
	public List<DISEASES_NAMES> getDiseasesNames()
	{
	  return 	disease_repo.getAllDiseases();
	}
}
