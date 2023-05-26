import { Component, OnInit } from '@angular/core';
import { ExportExcelService } from '../../../utils/export-excel.service';
import { environment } from '../../../../environments/environment';
import Swal from 'sweetalert2';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SessionStorageService } from 'angular-web-storage';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DatePipe } from '@angular/common';
@Component({
  selector: 'app-backup',
  templateUrl: './backup.component.html',
  styleUrls: ['./backup.component.css']
})
export class BackupComponent implements OnInit {

 
  loader: boolean = false;
  show: boolean = false;

  submitted: boolean = false;


  constructor(private session: SessionStorageService,
    private http: HttpClient,
    private exportService: ExportExcelService,
   ) { }

  ngOnInit(): void {
  }

  getAllLogin()
  {
    this.loader=true; 
    this.http.get(environment.url + "selectall/login").subscribe((response: any) => {
      this.loader = false;
      this.exportAsXsls(response,'logincredential');
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

  getDiseases()
  {
    this.loader=true; 
    this.http.get(environment.url + "selectall/diseases").subscribe((response: any) => {
      this.loader = false;
      this.exportAsXsls(response,'diseases');
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

  getNewRegistration()
  {
    this.loader=true; 
    this.http.get(environment.url + "selectall/new-regis").subscribe((response: any) => {
      this.loader = false;
      this.exportAsXsls(response,'new_regis');
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

  getpatientRevisit()
  {
    this.loader=true; 
    this.http.get(environment.url + "selectall/patient-revisit").subscribe((response: any) => {
      this.loader = false;
      this.exportAsXsls(response,'patient_revisit');
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


  getRegistrationCount()
  {
    this.loader=true; 
    this.http.get(environment.url + "selectall/registration-no").subscribe((response: any) => {
      this.loader = false;
      this.exportAsXsls(response,'registration_no');
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


  

  // downlaod in excel format
  exportAsXsls(data, filename: string): void {
    this.exportService.exportAsExcelFile(data, filename);
  }

  




}
