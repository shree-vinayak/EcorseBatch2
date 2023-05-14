package com.sv.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sv.entity.ListToStringConverter;
import com.sv.entity.NewRegistration;
import com.sv.entity.Patient_Revisit;
import com.sv.model.DoctorWiseCountDto;
import com.sv.model.GeneralResponseBody;
import com.sv.model.NewRegistrationDto;
import com.sv.model.PatientRevisitDto;
import com.sv.repository.Repo_NewRegistration;
import com.sv.repository.Repo_Patient_Revisit;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/revisit")
public class PatientRevisitController {

	@Autowired
	private Repo_NewRegistration repo_new_regis;

	@Autowired
	private Repo_Patient_Revisit repo_revisit;

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy 'at' hh:mm a");
	DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm a");

	@PostMapping("/save-revisit")
	public Object saveRevisit(@RequestBody Patient_Revisit obj) {
		GeneralResponseBody resp = new GeneralResponseBody();
		LocalDateTime datetime = LocalDateTime.now();
		LocalDate date = datetime.toLocalDate();

		NewRegistration olddetails = repo_new_regis.getPatientDetails(obj.getRegis_number());
		if (date.isBefore(olddetails.getValidtill().toLocalDate())
				|| date.equals(olddetails.getValidtill().toLocalDate())) {
			try {

				int i = repo_revisit.insertRec(obj.getDiseases(), datetime, obj.getRegis_number(), obj.getDoctors(),
						obj.getRefer(), obj.getRoomno(), obj.getEntryby());
				if (i > 0) {
					Map<String, Object> result = new LinkedHashMap<>();
					result.put("name", olddetails.getName());
					result.put("fname", olddetails.getFname());
					result.put("regis_number", olddetails.getRegis_number());
					result.put("mobileno", olddetails.getMobileno());
					result.put("age", olddetails.getAge());
					result.put("gender", olddetails.getGender());
					result.put("cast", olddetails.getCast());
					result.put("address", olddetails.getAddress());
					result.put("scheme", olddetails.getScheme());
					result.put("regisration_date", olddetails.getRegisration_date());
					result.put("validtill", olddetails.getValidtill());
					result.put("diseases", obj.getDiseases());
					result.put("doctors", obj.getDoctors());
					result.put("revisitdate", datetime);
					result.put("roomno", obj.getRoomno());
					result.put("refer", obj.getRefer());

					resp.setFlag(true);
					resp.setData(result);
					resp.setMsg("Save Successfully.");
				} else {
					resp.setFlag(false);
					resp.setData(null);
					resp.setMsg("Can Not Create Revisit Ticket.Try Again");
				}

			} catch (Exception e) {
				e.printStackTrace();
				resp.setFlag(false);
				resp.setData(null);
				resp.setMsg("Can Not Create Revisit Ticket.Try Again");

			}
		} else {
			resp.setFlag(false);
			resp.setData(null);
			resp.setMsg("Can Not Create Revisit Ticket.Valid Date Is Expired.");
		}

		return resp;
	}

	@PostMapping("/doctor-wise-summary")
	public Object getDoctorWiseSummaryReport(@RequestParam("startdate") String startdate_e,
			@RequestParam("enddate") String enddate_e) {
		GeneralResponseBody resp = new GeneralResponseBody();
		LocalDateTime startdate = LocalDateTime.of(LocalDateTime.parse(startdate_e, dtf).toLocalDate(), LocalTime.MIN);
		LocalDateTime enddate = LocalDateTime.of(LocalDateTime.parse(enddate_e, dtf).toLocalDate(), LocalTime.MAX);

		List<Object[]> rawDoctorWiseCount = repo_new_regis.getDoctorWiseCount(startdate, enddate);
		List<DoctorWiseCountDto> resultList = new ArrayList<>();

		for (Object o[] : rawDoctorWiseCount) {
			DoctorWiseCountDto dto = new DoctorWiseCountDto();
			dto.setDoctorname(o[1].toString());
			dto.setCount(o[0].toString());

			resultList.add(dto);
		}

		System.out.println("resultList.size() " + resultList.size());
		if (resultList.size() > 0) {
			resp.setFlag(true);
			resp.setData(resultList);
			resp.setMsg("Get Successfully.");
		} else {
			resp.setFlag(false);
			resp.setData(null);
			resp.setMsg("No Data Available For This Date Range.");
		}
		return resp;

	}

	@PostMapping("/doctor-wise-new-patient-report")
	public Object doctorWiseNewPatientReport(@RequestParam("startdate") String startdate_e,
			@RequestParam("enddate") String enddate_e, @RequestParam("doctorname") String doctorname_e) {
		GeneralResponseBody resp = new GeneralResponseBody();
		LocalDateTime startdate = LocalDateTime.of(LocalDate.parse(startdate_e, dt), LocalTime.MIN);
		LocalDateTime enddate = LocalDateTime.of(LocalDate.parse(enddate_e, dt), LocalTime.MAX);
		ListToStringConverter converter = new ListToStringConverter();

		List<NewRegistration> rawallPatienDetailLIst = repo_new_regis.getNewRegistrationDetails(startdate, enddate,
				doctorname_e);
		List<NewRegistrationDto> allPatienDetailLIst = new ArrayList<>();
		for (NewRegistration r : rawallPatienDetailLIst) {
			NewRegistrationDto data = new NewRegistrationDto();
			data.setRegis_number(r.getRegis_number());
			data.setName(r.getName());
			data.setFname(r.getFname());
			data.setRegisration_date(r.getRegisration_date());
			data.setMobileno(r.getMobileno());
			data.setAge(r.getAge());
			data.setGender(r.getGender());
			data.setCast(r.getCast());
			data.setScheme(r.getScheme());
			data.setDoctors(r.getDoctors());
			data.setAddress(r.getAddress());
			data.setRefer(r.getRefer());
			data.setRoomno(r.getRoomno());
			data.setPatientdiseases(converter.convertToDatabaseColumn(r.getPatientdiseases()));
			data.setValidtill(r.getValidtill());
			data.setEntryby(r.getEntryby());
			allPatienDetailLIst.add(data);
		}
		System.out.println("resultList.size() " + allPatienDetailLIst.size());
		if (allPatienDetailLIst.size() > 0) {
			resp.setFlag(true);
			resp.setData(allPatienDetailLIst);
			resp.setMsg("Get Successfully.");
		} else {
			resp.setFlag(false);
			resp.setData(null);
			resp.setMsg("No Data Available For This Date Range.");
		}
		return resp;

	}
	
	
	@PostMapping("/doctor-wise-summary-for-revisit-patient")
	public Object getDoctorWiseSummaryReportForRevisitPatient(
			@RequestParam("startdate") String startdate_e,
			@RequestParam("enddate") String enddate_e) {
		GeneralResponseBody resp = new GeneralResponseBody();
		LocalDateTime startdate = LocalDateTime.of(LocalDate.parse(startdate_e, dt), LocalTime.MIN);
		LocalDateTime enddate = LocalDateTime.of(LocalDate.parse(enddate_e, dt), LocalTime.MAX);

		List<Object[]> rawDoctorWiseCount = repo_revisit.getDoctorWiseCount(startdate, enddate);
		List<DoctorWiseCountDto> resultList = new ArrayList<>();

		for (Object o[] : rawDoctorWiseCount) {
			DoctorWiseCountDto dto = new DoctorWiseCountDto();
			dto.setDoctorname(o[1].toString());
			dto.setCount(o[0].toString());

			resultList.add(dto);
		}

		System.out.println("resultList.size() " + resultList.size());
		if (resultList.size() > 0) {
			resp.setFlag(true);
			resp.setData(resultList);
			resp.setMsg("Get Successfully.");
		} else {
			resp.setFlag(false);
			resp.setData(null);
			resp.setMsg("No Data Available For This Date Range.");
		}
		return resp;

	}
	
	
	@PostMapping("/revisit_patient-info-for-doctor")
	public Object revisitPatientInforForDoctor(
			@RequestParam("startdate") String startdate_e,
			@RequestParam("enddate") String enddate_e,
			@RequestParam("doctorname") String doctorname_e) {
		GeneralResponseBody resp = new GeneralResponseBody();
		LocalDateTime startdate = LocalDateTime.of(LocalDate.parse(startdate_e, dt), LocalTime.MIN);
		LocalDateTime enddate = LocalDateTime.of(LocalDate.parse(enddate_e, dt), LocalTime.MAX);

		List<Object[]> rawallPatienDetailLIst = repo_revisit.getAllRevisitPatientDetails(startdate, enddate,
				doctorname_e);
		
		List<PatientRevisitDto> allPatienDetailLIst = new ArrayList<>();
		
		for (Object[] obj : rawallPatienDetailLIst) {
			
			PatientRevisitDto data = new PatientRevisitDto();
			data.setDiseases(obj[0].toString());
			data.setRevisitdate(obj[1].toString());
			data.setRegis_number(obj[2].toString());
			data.setDoctors(obj[3].toString());
			data.setRefer(obj[4].toString());
			data.setRoomno(obj[5].toString());
			data.setEntryby(obj[6].toString());
			data.setName(obj[7].toString());
			data.setFname(obj[8].toString());
			data.setRegisration_date(obj[9].toString());
			data.setMobileno(obj[10].toString());
			data.setAge(obj[11].toString());
			data.setGender(obj[12].toString());
			data.setCast(obj[13].toString());
			data.setScheme(obj[14].toString());
			data.setAddress(obj[15].toString());
			data.setValidtill(obj[16].toString());
			
			allPatienDetailLIst.add(data);
		}
		System.out.println("resultList.size() " + allPatienDetailLIst.size());
		if (allPatienDetailLIst.size() > 0) {
			resp.setFlag(true);
			resp.setData(allPatienDetailLIst);
			resp.setMsg("Get Successfully.");
		} else {
			resp.setFlag(false);
			resp.setData(null);
			resp.setMsg("No Data Available For This Date Range.");
		}
		return resp;

	}
	
}
