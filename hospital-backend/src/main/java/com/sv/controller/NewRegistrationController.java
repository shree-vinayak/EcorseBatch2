package com.sv.controller;

import java.time.LocalDateTime;
import java.time.Year;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sv.entity.NewRegistration;
import com.sv.entity.REGISTRATION_NO_AUTO;
import com.sv.model.GeneralResponseBody;
import com.sv.repository.Repo_NewRegistration;
import com.sv.repository.Repo_REGISTRATION_NO_AUTO;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/registration")
public class NewRegistrationController {
	
	
	@Autowired
	private Repo_NewRegistration repo_new_regis; 
	
	@Autowired
	private Repo_REGISTRATION_NO_AUTO regis_repo;
	
	
	@PostMapping("/save-new-registration")
	public Object saveNewRegistration(@RequestBody NewRegistration obj)
	{
		GeneralResponseBody resp  = new GeneralResponseBody(); 
		LocalDateTime datetime= LocalDateTime.now();
		try
		{
			String currentyear = Year.now().toString();
			REGISTRATION_NO_AUTO regisObj = regis_repo.findById(currentyear).get();
			Integer updatedval = Integer.parseInt(regisObj.getCount())+1;
		    int i=	regis_repo.updatecount(updatedval.toString(),currentyear);
		    if(i>0)
		    {
		    	obj.setRegis_number(regisObj.getCount().toString());
		    	obj.setRegisration_date(datetime);
				obj.setValidtill(datetime.plusDays(7));
				NewRegistration saveObj = repo_new_regis.save(obj);
				if(saveObj!=null)
				{
					resp.setFlag(true);
					resp.setData(saveObj);
					resp.setMsg("Save Successfully.");
				}
				else
				{
					resp.setFlag(false);
					resp.setData(null);
					resp.setMsg("Can Not Register New Patient.");
				}
		    }
		    else
		    {
		    	resp.setFlag(false);
				resp.setData(null);
				resp.setMsg("Can Not Update Registration No. Try Again.");
		    }
		}
		catch (Exception e)
		{
			e.printStackTrace();
			resp.setFlag(false);
			resp.setData(null);
			resp.setMsg("Can Not Register New Patient.Contact To Development Team.");
			
		}
		
		
		return resp; 
	}

}
