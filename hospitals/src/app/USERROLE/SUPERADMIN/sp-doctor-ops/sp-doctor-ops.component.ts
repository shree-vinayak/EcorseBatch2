import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SessionStorageService } from 'angular-web-storage';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { ExportExcelService } from '../../../utils/export-excel.service';
import { environment } from '../../../../environments/environment';

@Component({
  selector: 'app-sp-doctor-ops',
  templateUrl: './sp-doctor-ops.component.html',
  styleUrls: ['./sp-doctor-ops.component.css']
})
export class SpDoctorOPSComponent implements OnInit {
  loader: boolean = false;
  submitted: boolean = false;
  doctorOpsForm: FormGroup = null;
  doctorResp:any=null;
 



  constructor(private session: SessionStorageService,
    private router: Router,
    private http: HttpClient,
    private fb: FormBuilder,
    private datepipe: DatePipe,
    private exportService: ExportExcelService,
    private active: ActivatedRoute) { }

  ngOnInit(): void {
   
    this.doctorOpsForm = this.fb.group(
      {
        doctorname: ['', Validators.required],
        mobileNo: ['', Validators.required],
        address: ['', Validators.required]
      });
    this.getAllDoctors();
   
  }

  get f1() {
    return this.doctorOpsForm.controls;
  }


  //FETCH ALL DISEASES FROM DATABASE
  getAllDoctors() {
    this.loader = true;
    this.doctorResp=null;
    this.http.get(environment.url + "super/get-all-doctors").subscribe((response: any) => {

      this.loader = false;
      if (response.flag === true) {
        this.doctorResp = response.data;
      }
      else {
        alert(response.msg);
        this.doctorResp = null;
      }
    });
  }



  //Save new register patient 
  submit() {
    this.submitted = true;
    this.loader = true;
    if (this.doctorOpsForm.invalid) {
      this.loader = false;
      return;
    }

    this.http.post(environment.url + "super/save-doctor",this.doctorOpsForm.getRawValue()).subscribe((response: any) => {
      this.loader = false;
      this.submitted=false; 
      this.doctorOpsForm.reset();
      if (response.flag === true)
      {
        alert(response.msg);
       
      }
      else 
      {
        alert(response.msg);
      }
      this.getAllDoctors();
    });
  }


  //To delete a doctor from table 
  deleteDoctors(doctor:any) {
    debugger;
  let value:boolean=confirm('Are you sure, you want to delete doctor '+doctor.doctorname);
  if(value)
  {
    this.loader = true;
    let formdata= new FormData();
    formdata.append('doctorid',doctor.doctorid);

    this.http.post(environment.url + "super/delete-doctors",formdata).subscribe((response: any) => {

      this.loader = false;
      alert(response.msg);
      this.getAllDoctors();
    });
  }
    
  }




}
