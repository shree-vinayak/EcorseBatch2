import { Component, OnInit } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SessionStorageService } from 'angular-web-storage';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { ExportExcelService } from '../../../utils/export-excel.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-revisit-report',
  templateUrl: './revisit-report.component.html',
  styleUrls: ['./revisit-report.component.css']
})
export class RevisitReportComponent implements OnInit {

  dateRangeForm: FormGroup;

  loader: boolean = false;
  revisitOpdReportResp: any = null;
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
    this.getRevisitOpdReport();
    
  }

  get f1() {
    return this.dateRangeForm.controls;
  }

  getRevisitOpdReport() {
    debugger
    this.revisitOpdReportResp = null;
    if (this.dateRangeForm.invalid|| this.dateRangeForm.controls.endDate.value === "" || this.dateRangeForm.controls.endDate.value == null) {
      return;
    }
    else {
      this.loader = true;

      let formData = new FormData();
      formData.append("startdate", this.datepipe.transform(this.dateRangeForm.controls.startDate.value, "dd-MM-yyyy 'at' hh:mm a"));
      formData.append("enddate", this.datepipe.transform(this.dateRangeForm.controls.endDate.value, "dd-MM-yyyy 'at' hh:mm a"));
      return this.http.post(environment.url + "report/revisit_patient-info", formData).subscribe((response: any) => {
debugger;
        if (response.flag === true) {
          this.revisitOpdReportResp = response;
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
    this.revisitOpdReportResp = null;
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