import { Component, OnInit } from '@angular/core';

import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { SessionStorageService } from 'angular-web-storage';
import { ExportExcelService } from '../../../utils/export-excel.service';
import { environment }  from '../../../../environments/environment';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {
  dashboardForm: FormGroup;

  loader: boolean = false;

  show: boolean = false;
  diseases: any = null;
  aadharValidation:boolean=false;

  submitted: boolean = false;
  registerPatient: FormGroup = null;
  todayDate: Date = null;

  addedDiseases: string[] = [];



  constructor(private session: SessionStorageService,
    private router: Router,
    private http: HttpClient,
    private fb: FormBuilder,
    private datepipe: DatePipe,
    private exportService: ExportExcelService,
    private active: ActivatedRoute) { }

  ngOnInit(): void {
    this.todayDate = new Date();
    
    this.registerPatient = this.fb.group(
      {
        name: ['', Validators.required],
        fname: ['', Validators.required],
        mobileno: [''],
        age: ['', Validators.required],
        gender: ['', Validators.required],
        cast: ['', Validators.required],
        scheme: ['', Validators.required],
        aadharnumber:[0],
        doctors: ['', Validators.required],
        address: ['', Validators.required],
        refer: [''],
        roomno: ['Room No.1', Validators.required],
        patientdiseases: [''],
        entryby: [this.session.get('loginid'), Validators.required]

      });
    this.getAllDiseases();
    // this.getRegistrationNo();
  }

  get f1() {
    return this.registerPatient.controls;
  }

  //get registration no
  // getRegistrationNo() {
  //   this.loader = true;
  //   this.http.get(environment.url + "registration-ops/get-no").subscribe((response: any) => {

  //     this.loader = false;
  //     if (response.flag === true) {
  //       let data = response.data;
  //       this.registerPatient.patchValue(
  //         {
  //           regis_number: data.count
  //         });
  //       this.registerPatient.controls['regis_number'].disable();
  //     }
  //     else {
  //       alert(response.msg);
  //     }
  //   });
  // }


  //FETCH ALL DISEASES FROM DATABASE
  getAllDiseases() {
    this.loader = true;
    this.http.get(environment.url + "diseases/get-all-disease").subscribe((response: any) => {

      this.loader = false;
      if (response.flag === true) {
        this.diseases = response.data;
      }
      else {
        alert(response.msg);
        this.diseases = null;
      }
    });
  }


  //add diesesases to the array
  addPatientDiseases() {
    if (this.addedDiseases.indexOf(this.f1.patientdiseases.value) == -1) {
      this.addedDiseases.push(this.f1.patientdiseases.value);
      this.registerPatient.patchValue({
        patientdiseases: ''
      });
    }
    else {
      this.registerPatient.patchValue({
        patientdiseases: ''
      });
      return;
    }
  }


  //remove diseases from array 
  removeDiseases(data: string) {
    this.addedDiseases.splice(this.addedDiseases.indexOf(data), 1);
  }



  //Save new register patient 
  submit() {
    debugger;
    this.submitted = true;
    this.loader = true;

    if (this.registerPatient.invalid) {
      this.loader = false;
      return;
    }

    debugger
    let aadharvalue:string=this.f1.aadharnumber.value;
    if(aadharvalue!=null &&aadharvalue!=''&& aadharvalue!=undefined)
    {
       if(aadharvalue.length<12)
       {
         this.aadharValidation=true;
         return; 
       }
    }
    this.loader = false;
    

    this.registerPatient.patchValue({
      patientdiseases:this.addedDiseases
    });
    this.http.post(environment.url + "registration/save-new-registration",this.registerPatient.getRawValue()).subscribe((response: any) => {
      this.loader = false;
      this.submitted=false; 
      this.registerPatient.reset();
      if (response.flag === true)
      {
        console.log(response.data);
        let data:any= JSON.stringify(response.data);
        this.router.navigate(['/file',data]);
      }
      else 
      {
        alert(response.msg);
      }
    });

  }




  // download record 
  // let date1 = this.datepipe.transform(this.f1.startDate.value, "dd-MMM-yyyy");
  //   let date2 = this.datepipe.transform(this.f1.endDate.value, "dd-MMM-yyyy");



  // downlaod in excel format
  exportAsXsls(data, filename: string): void {
    this.exportService.exportAsExcelFile(data, filename);
  }

  createExcelForIncomingCallResp(data) {
    this.exportService.exportAsExcelFile(data, 'Incoming_call_for_dtmf_');
  }



}
