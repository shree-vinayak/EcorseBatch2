import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AdminService } from 'src/app/Services/admin.service';

@Component({
  selector: 'app-student-result',
  templateUrl: './student-result.component.html',
  styleUrls: ['./student-result.component.css']
})
export class StudentResultComponent implements OnInit {

  resultForm: FormGroup = null;
  studentData: any = null;
  classList: any = null;


  constructor(private adminservice: AdminService) { }

  ngOnInit() {


    this.adminservice.getClassesList().subscribe((response: any) => {
      this.classList = response;
    });


    this.resultForm = new FormGroup({
      studentclass: new FormControl('', [Validators.required]),
      username:new FormControl('',[Validators.required])
    });
  }

  getStudentDetails(event: any) {
    this.adminservice.getApi("getStudentDetailsForClass?studentclass=" + event.target.value).subscribe((response: any) => {
      if (response.status) {
        this.studentData = response.data;
      }
      else {
        alert(response.message);
      }

    }, (error: any) => {
      console.log(error)
    })
  }

}
