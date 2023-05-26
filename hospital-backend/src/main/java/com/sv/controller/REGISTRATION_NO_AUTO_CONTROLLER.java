package com.sv.controller;

import java.time.Year;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sv.entity.NewRegistration;
import com.sv.entity.REGISTRATION_NO_AUTO;
import com.sv.model.GeneralResponseBody;
import com.sv.repository.Repo_NewRegistration;
import com.sv.repository.Repo_REGISTRATION_NO_AUTO;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/registration-ops")
public class REGISTRATION_NO_AUTO_CONTROLLER {

	@Autowired
	private Repo_REGISTRATION_NO_AUTO regis_repo;
	
	@Autowired
	private  Repo_NewRegistration repo_new_regis;

	@GetMapping(value = "/get-no")
	public GeneralResponseBody getRegistrationNo() {
		String currentyear = Year.now().toString();
		REGISTRATION_NO_AUTO regisObj = regis_repo.findById(currentyear).get();
		GeneralResponseBody resp = new GeneralResponseBody();
		if (regisObj != null)
		{
		   resp.setFlag(true);
		   resp.setMsg("Get Successfully");
		   resp.setData(regisObj);
		}
		else 
		{
			resp.setFlag(false);
			resp.setMsg("Can Not Get Registration No. Contact To Development Team.");
			resp.setData(null);
		}

		return resp;
	}
	
	@PostMapping(value = "/get-patient-details-for-registration-no")
	public GeneralResponseBody getPatientDetails(@RequestParam("registration_no") Long registration_no) {
		GeneralResponseBody resp = new GeneralResponseBody();
		
		NewRegistration details=  repo_new_regis.getPatientDetails(registration_no.toString());
		if (details != null)
		{
		   resp.setFlag(true);
		   resp.setMsg("Get Successfully");
		   resp.setData(details);
		}
			else 
			{
			resp.setFlag(false);
			resp.setMsg("No Details Available For This Registration Number.");
			resp.setData(null);
		}

		return resp;
	}

}
