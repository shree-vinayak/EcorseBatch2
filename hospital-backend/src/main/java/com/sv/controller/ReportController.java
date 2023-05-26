package com.sv.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sv.dto.NewRegistrationDTO;
import com.sv.entity.NewRegistration;
import com.sv.model.GeneralResponseBody;
import com.sv.model.PatientRevisitDto;
import com.sv.repository.Repo_NewRegistration;
import com.sv.repository.Repo_Patient_Revisit;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private Repo_NewRegistration repo_new_regis;

	@Autowired
	private Repo_Patient_Revisit repo_revisit;

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy 'at' hh:mm a");
	DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm a");

	@PostMapping("/new-opd-report")
	public Object getDoctorWiseSummaryReport(@RequestParam("startdate") String startdate_e,
			@RequestParam("enddate") String enddate_e) {
		GeneralResponseBody resp = new GeneralResponseBody();
		LocalDateTime startdate = LocalDateTime.of(LocalDateTime.parse(startdate_e, dtf).toLocalDate(), LocalTime.MIN);
		LocalDateTime enddate = LocalDateTime.of(LocalDateTime.parse(enddate_e, dtf).toLocalDate(), LocalTime.MAX);
		List<NewRegistration> resultList = repo_new_regis.getNewOPDReport(startdate, enddate);
		System.out.println("resultList.size() " + resultList.size());
		Integer count = resultList.size();
		List<NewRegistrationDTO> registrationDtoList = new ArrayList<>();
		for (int i = 0; i < resultList.size(); i++) {
			NewRegistration registration = resultList.get(i);
			NewRegistrationDTO dto = new NewRegistrationDTO();
			dto.setRegis_number(registration.getRegis_number());
			dto.setName(registration.getName());
			dto.setFname(registration.getFname());
			dto.setRegisration_date(registration.getRegisration_date());
			dto.setMobileno(registration.getMobileno());
			dto.setAge(registration.getAge());
			dto.setGender(registration.getGender());
			dto.setCast(registration.getCast());
			dto.setScheme(registration.getScheme());
			dto.setDoctors(registration.getDoctors());
			dto.setAddress(registration.getAddress());
			dto.setRefer(registration.getRefer());
			dto.setRoomno(registration.getRoomno());
			dto.setPatientdiseases(String.join(",", registration.getPatientdiseases()));
			dto.setValidtill(registration.getValidtill());
			dto.setEntryby(registration.getEntryby());
			dto.setAadharnumber(registration.getAadharnumber());
			registrationDtoList.add(dto);
		}
		if (count > 0) {
			resp.setFlag(true);
			resp.setData(registrationDtoList);
			resp.setMsg("Get Successfully.");
			resp.setCount(count);
		} else {
			resp.setFlag(false);
			resp.setData(null);
			resp.setMsg("No Data Available For This Date Range.");
		}
		return resp;
	}
	
	@PostMapping("/revisit_patient-info")
	public Object revisitPatientInfor(
			@RequestParam("startdate") String startdate_e,
			@RequestParam("enddate") String enddate_e) {
		GeneralResponseBody resp = new GeneralResponseBody();
		LocalDateTime startdate = LocalDateTime.of(LocalDate.parse(startdate_e, dtf), LocalTime.MIN);
		LocalDateTime enddate = LocalDateTime.of(LocalDate.parse(enddate_e, dtf), LocalTime.MAX);

		List<Object[]> rawallPatienDetailLIst = repo_revisit.getAllRevisitPatientDetails(startdate,
				    enddate);
		
		List<PatientRevisitDto> allPatienDetailLIst = new ArrayList<>();
		
		for (Object[] obj : rawallPatienDetailLIst) {
			
			PatientRevisitDto data = new PatientRevisitDto();
			data.setDiseases(checkForNull(obj[0]));
			data.setRevisitdate(checkForNull(obj[1]));
			data.setRegis_number(checkForNull(obj[2]));
			data.setDoctors(checkForNull(obj[3]));
			data.setRefer(checkForNull(obj[4]));
			data.setRoomno(checkForNull(obj[5]));
			data.setEntryby(checkForNull(obj[6]));
			data.setName(checkForNull(obj[7]));
			data.setFname(checkForNull(obj[8]));
			data.setRegisration_date(checkForNull(obj[9]));
			data.setMobileno(checkForNull(obj[10]));
			data.setAge(checkForNull(obj[11]));
			data.setGender(checkForNull(obj[12]));
			data.setCast(checkForNull(obj[13]));
			data.setScheme(checkForNull(obj[14]));
			data.setAddress(checkForNull(obj[15]));
			data.setValidtill(checkForNull(obj[16]));
			data.setAadharnumber(checkForNull(obj[17]));
			allPatienDetailLIst.add(data);
		}
		System.out.println("resultList.size() " + allPatienDetailLIst.size());
		if (allPatienDetailLIst.size() > 0) {
			resp.setFlag(true);
			resp.setData(allPatienDetailLIst);
			resp.setMsg("Get Successfully.");
			resp.setCount(rawallPatienDetailLIst.size());
		} else {
			resp.setFlag(false);
			resp.setData(null);
			resp.setMsg("No Data Available For This Date Range.");
		}
		return resp;
	}
	
	private static String checkForNull(Object value)
	{
		return value==null?"":value.toString();
		
	}

}
