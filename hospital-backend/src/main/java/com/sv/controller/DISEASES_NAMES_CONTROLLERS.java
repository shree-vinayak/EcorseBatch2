package com.sv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sv.entity.DISEASES_NAMES;
import com.sv.model.GeneralResponseBody;
import com.sv.service.DiseasesNamesService;

@RestController
@RequestMapping(value = "/diseases")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class DISEASES_NAMES_CONTROLLERS {

	
	@Autowired 
	private DiseasesNamesService diseases_service;
	
	@GetMapping(value = "/get-all-disease")
	public Object getAllDiseases()
	{
		List<DISEASES_NAMES> result= diseases_service.getDiseasesNames();
		GeneralResponseBody response = new GeneralResponseBody(); 
		
		if(result.size()>0)
		{
			response.setFlag(true);
			response.setData(result);
			response.setMsg("Get Successfully");
		}
		else
		{
			response.setFlag(false);
			response.setData(null);
			response.setMsg("No Data Available, Contact To Development Team.");
		}
		
		return response;
		
		
	}
}
