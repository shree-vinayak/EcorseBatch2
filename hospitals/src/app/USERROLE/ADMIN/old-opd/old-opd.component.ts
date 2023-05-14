import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SessionStorageService } from 'angular-web-storage';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { ExportExcelService } from '../../../utils/export-excel.service';
import { environment } from '../../../../environments/environment';

declare var $: any;
@Component({
  selector: 'app-old-opd',
  templateUrl: './old-opd.component.html',
  styleUrls: ['./old-opd.component.css']
})
export class OldOpdComponent implements OnInit {
  dashboardForm: FormGroup;

  loader: boolean = false;

  show: boolean = false;
  diseases: any = null;

  submitted: boolean = false;
  patientrevisitform: FormGroup = null;
  todayDate: Date = null;

  addedDiseases: string[] = [];

  patientDetailResp: any = null;



  constructor(private session: SessionStorageService,
    private router: Router,
    private http: HttpClient,
    private fb: FormBuilder,
    private datepipe: DatePipe,
    private exportService: ExportExcelService,
    private active: ActivatedRoute) { }

  ngOnInit(): void {
    this.todayDate = new Date();


    this.getAllDiseases();
  }

  get f1() {
    return this.patientrevisitform.controls;
  }

  //get registration no
  getPatientDetails() {
    this.patientDetailResp = null;
    var val = $('#search').val();

    this.loader = true;
    let formdata = new FormData();
    formdata.append("registration_no", val);
    this.http.post(environment.url + "registration-ops/get-patient-details-for-registration-no", formdata).subscribe((response: any) => {

      this.addedDiseases=[];
      this.loader = false;
      if (response.flag === true) {
        this.patientDetailResp = response.data;
        console.log(this.patientDetailResp);

        this.patientrevisitform = this.fb.group(
          {
            name: [{ value: this.patientDetailResp.name, disabled: true }, Validators.required],
            fname: [{ value: this.patientDetailResp.fname, disabled: true }, Validators.required],
            regis_number: [{ value: this.patientDetailResp.regis_number, disabled: true }, Validators.required],
            regis_date: [{ value: this.patientDetailResp.regisration_date, disabled: true }, Validators.required],
            mobileno: [{ value: this.patientDetailResp.mobileno, disabled: true }, Validators.required],
            age: [{ value: this.patientDetailResp.age, disabled: true }, Validators.required],
            gender: [{ value: this.patientDetailResp.gender, disabled: true }, Validators.required],
            cast: [{ value: this.patientDetailResp.cast, disabled: true }, Validators.required],
            scheme: [{ value: this.patientDetailResp.scheme, disabled: true }, Validators.required],
            doctors: [ this.patientDetailResp.doctors, Validators.required],
            address: [{ value: this.patientDetailResp.address, disabled: true }, Validators.required],
            refer: [this.patientDetailResp.refer],
            roomno: [this.patientDetailResp.roomno, Validators.required],
            patientOldDiseases:[{value:this.patientDetailResp.patientdiseases,disabled:true}],
            patientdiseases: ['']
           
          });
         this.addedDiseases= this.patientDetailResp.patientdiseases;

        // this.patientrevisitform .controls['regis_number'].disable();
      }
      else {
        alert(response.msg);
      }
    });
  }


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
      this.patientrevisitform.patchValue({
        patientdiseases: ''
      });
    }
    else {
      this.patientrevisitform
        .patchValue({
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

    if (this.patientrevisitform.invalid) {
      this.loader = false;
      return;
    }
    this.loader = false;


   
    let obj ={
      diseases:this.addedDiseases.toString(),
      regis_number:this.f1.regis_number.value,
      doctors:this.f1.doctors.value,
      refer:this.f1.refer.value, 
      roomno:this.f1.roomno.value,
      entryby: this.session.get('loginid')

    }


    
    this.http.post(environment.url + "revisit/save-revisit",obj).subscribe((response: any) => {
        this.loader = false;
        this.submitted = false;
        this.patientrevisitform.reset();
        this.addedDiseases=[];
    

        if (response.flag === true) {
          console.log(response.data);
          let data: any = JSON.stringify(response.data);
          this.router.navigate(['/patient-revisit-ticket', data]);
        }
        else {
          alert(response.msg);
        }
        this.patientDetailResp=null;
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
