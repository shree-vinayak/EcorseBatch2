import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { SessionStorageService } from 'angular-web-storage';
import { ExportExcelService } from '../../../utils/export-excel.service';
import { environment } from '../../../../environments/environment';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-doctor-wise-report',
  templateUrl: './doctor-wise-report.component.html',
  styleUrls: ['./doctor-wise-report.component.css']
})
export class DoctorWiseReportComponent implements OnInit {


  dateRangeForm: FormGroup;

  loader: boolean = false;
  doctorSummaryResp: any = null;
  show: boolean = false;

  submitted: boolean = false;

  todayDate: Date;

  constructor(private session: SessionStorageService,
    private router: Router,
    private http: HttpClient,
    private fb: FormBuilder,
    private datepipe: DatePipe,
    private exportService: ExportExcelService,
    private active: ActivatedRoute) { }

  ngOnInit(): void {
    this.todayDate = new Date();
    this.dateRangeForm = this.fb.group(
      {
        startDate: [new Date(), Validators.required],
        endDate: [new Date(), Validators.required]
      }
    )
    this.getDoctorWiseSummaryReport();
  }

  get f1() {
    return this.dateRangeForm.controls;
  }

  getDoctorWiseSummaryReport() {
    this.doctorSummaryResp = null;

    if (this.dateRangeForm.controls.endDate.value === "" || this.dateRangeForm.controls.endDate.value == null) {

      return;
    }
    else {
      this.loader = true;

      let formData = new FormData();
      formData.append("startdate", this.datepipe.transform(this.dateRangeForm.controls.startDate.value, "dd-MM-yyyy 'at' hh:mm a"));
      formData.append("enddate", this.datepipe.transform(this.dateRangeForm.controls.endDate.value, "dd-MM-yyyy 'at' hh:mm a"));
      return this.http.post(environment.url + "revisit/doctor-wise-summary", formData).subscribe((response: any) => {

        if (response.flag === true) {
          this.doctorSummaryResp = response.data;
          this.loader = false;
          this.show = true;
        } else {
          this.loader = false;
          this.show = false;
        }
      },
        error => {
          this.loader = false;
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong!',
            showConfirmButton: false,
            timer: 3000
          });

        });
    }
  }

  getAllPatientForDoctor(doctorname:string) {

    if (this.dateRangeForm.controls.endDate.value === "" || this.dateRangeForm.controls.endDate.value == null) {

      return;
    }
    else {
      this.loader = true;

      let formData = new FormData();
      formData.append("startdate", this.datepipe.transform(this.dateRangeForm.controls.startDate.value, "dd-MM-yyyy"));
      formData.append("enddate", this.datepipe.transform(this.dateRangeForm.controls.endDate.value, "dd-MM-yyyy"));
      formData.append("doctorname",doctorname);
      return this.http.post(environment.url + "revisit/doctor-wise-new-patient-report", formData).subscribe((response: any) => {

        if (response.flag === true) {
          this.exportAsXsls(response.data,'PatientDetails')
          this.loader = false;
          this.show = true;
        } else {
          this.loader = false;
          this.show = false;
        }
      },
        error => {
          this.loader = false;
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong!',
            showConfirmButton: false,
            timer: 3000
          });

        });
    }
  }

  resetEndDate() {
    this.doctorSummaryResp = null;

    this.dateRangeForm.patchValue({
      endDate: ""
    })
  }

  // downlaod in excel format
  exportAsXsls(data, filename: string): void {
    this.exportService.exportAsExcelFile(data, filename);
  }

  createExcelForparkCallResp(data) {
    this.exportService.exportAsExcelFile(data, 'Incoming_call_for_dtmf_');
  }




}
