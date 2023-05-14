package com.sv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sv.entity.DISEASES_NAMES;
import com.sv.entity.HOSPITAL_LOGIN;
import com.sv.entity.NewRegistration;
import com.sv.entity.Patient_Revisit;
import com.sv.entity.REGISTRATION_NO_AUTO;
import com.sv.repository.Repo_DISEASES_NAMES;
import com.sv.repository.Repo_HOSPITAL_LOGIN;
import com.sv.repository.Repo_NewRegistration;
import com.sv.repository.Repo_Patient_Revisit;
import com.sv.repository.Repo_REGISTRATION_NO_AUTO;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/selectall")
public class SelectAllController {
	
	@Autowired
	private Repo_HOSPITAL_LOGIN loginrepo; 
	
	
	@Autowired 
	private Repo_DISEASES_NAMES diseaseRepo;
	
	@Autowired
	private Repo_NewRegistration newregisRepo;
	
	@Autowired
	private Repo_Patient_Revisit patientRepo;
	
	@Autowired
	private Repo_REGISTRATION_NO_AUTO   repo_registration_no_auto;
	 
    @GetMapping("/login")	
	public Object getLoginRows()
	{
		 List<HOSPITAL_LOGIN> list= loginrepo.findAll(Sort.by(Sort.Direction.ASC, "loginid"));
		
		 return list;
	}
	
    @GetMapping("/diseases")	
	public Object getDiseases()
	{
		 List<DISEASES_NAMES> list= diseaseRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
		
		 return list;
	}
    
    @GetMapping("/new-regis")	
   	public Object getNewRegistration()
   	{
   		 List<NewRegistration> list= newregisRepo.findAll();
   		
   		 return list;
   	}
    
    @GetMapping("/patient-revisit")	
   	public Object getpatientRevisit()
   	{
   		 List<Patient_Revisit> list= patientRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
   		
   		 return list;
   	}
    
    @GetMapping("/registration-no")	
   	public Object getRegistrationCount()
   	{
   		 List<REGISTRATION_NO_AUTO> list= repo_registration_no_auto.findAll(Sort.by(Sort.Direction.ASC, "year"));
   		
   		 return list;
   	}
	

}
