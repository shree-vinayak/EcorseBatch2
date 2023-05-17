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
  studentResultList: any = null;


  constructor(private adminservice: AdminService) { }

  ngOnInit() {


    this.adminservice.getClassesList().subscribe((response: any) => {
      this.classList = response;
    });


    this.resultForm = new FormGroup({
      studentclass: new FormControl('', [Validators.required]),
      username: new FormControl('', [Validators.required]),
      examtype:new FormControl('',[Validators.required]),
      physicsmarks:new FormControl('',[Validators.required]),
      chemistrymarks:new FormControl('',[Validators.required]),
      mathsmarks:new FormControl('',[Validators.required])
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

  getStudentResultList() {
    this.adminservice.getResultForStudent(this.resultForm.controls.username.value).subscribe(
      (respose: any) => {
        if (respose.status) {
          this.studentResultList = respose.data;
        }
        else {
          alert(respose.message);
          this.studentResultList = null;
        }
      }
    )
  }

  saveResult()
  {
    if(this.resultForm.invalid)
    {
      alert("form is invalid");
      return 
    }
     this.adminservice.saveResultForStudent(this.resultForm.value).subscribe((response:any)=>
     {
         alert(response.message);
         this.getStudentResultList();
     })
  }

}
