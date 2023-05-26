package com.sv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sv.entity.DoctorDetails;
import com.sv.model.GeneralResponseBody;
import com.sv.repository.Repo_DoctorDetails;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/super")
public class SuperAdminController {

	@Autowired
	private Repo_DoctorDetails repo_doctorDetail;

	@GetMapping(value = "/get-all-doctors")
	public Object getAllDiseases() {
		List<DoctorDetails> result = repo_doctorDetail.findAll();
		GeneralResponseBody response = new GeneralResponseBody();

		if (result.size() > 0) {
			response.setFlag(true);
			response.setData(result);
			response.setMsg("Get Successfully");
			response.setCount(result.size());
		} else {
			response.setFlag(false);
			response.setData(null);
			response.setMsg("No Data Available, Contact To Development Team.");
		}
		return response;
	}

	@PostMapping("/save-doctor")
	public Object saveNewRegistration(@RequestBody DoctorDetails obj) {
		GeneralResponseBody resp = new GeneralResponseBody();
		try {
			Integer maxid = repo_doctorDetail.getMaxDoctorId();
			obj.setDoctorid(maxid + 1);
			DoctorDetails saveObj = repo_doctorDetail.save(obj);
			if (saveObj != null) {
				resp.setFlag(true);
				resp.setData(saveObj);
				resp.setMsg("Save Successfully.");
			} else {
				resp.setFlag(false);
				resp.setData(null);
				resp.setMsg("Can Not Register New Doctor.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setFlag(false);
			resp.setData(null);
			resp.setMsg("Can Not Register New Doctor..Contact To Development Team.");

		}
		return resp;
	}
	
	@PostMapping(value = "/delete-doctors")
	public Object deleteDoctor(@RequestParam("doctorid")Integer doctorid) {
		 int  deletedRow = repo_doctorDetail.deleteDoctor(doctorid);
		GeneralResponseBody response = new GeneralResponseBody();

		if (deletedRow > 0) {
			response.setFlag(true);
			response.setData(null);
			response.setMsg("Deleted Successfully");
		} else {
			response.setFlag(false);
			response.setData(null);
			response.setMsg("Can Not Delete, Contact To Development Team.");
		}
		return response;
	}

}
