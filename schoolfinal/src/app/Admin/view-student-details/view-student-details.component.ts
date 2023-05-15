import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from 'src/app/Services/admin.service';
import { FormGroup, FormControl, Validators, AbstractControl } from '@angular/forms';

@Component({
  selector: 'app-view-student-details',
  templateUrl: './view-student-details.component.html',
  styleUrls: ['./view-student-details.component.css']
})
export class ViewStudentDetailsComponent implements OnInit {

  studentDetail:any=null;

  studentDetailsForm:FormGroup=null;
  
  constructor(private active:ActivatedRoute,
     private adminservice:AdminService,
     private router:Router) { }
  ngOnInit() {

    this.studentDetailsForm = new FormGroup({
      rollNo:new FormControl({value:'',disabled:true},[Validators.required]),
      name: new FormControl('', [Validators.required, Validators.minLength(3), 
        Validators.pattern("^[a-zA-Z]+$")]),
      fathername: new FormControl('', [Validators.required, Validators.minLength(3),
        Validators.pattern("^[a-zA-Z]+$")]),
      username: new FormControl('', [Validators.required, Validators.email]),
      studentclass: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),
      phoneno: new FormControl('', [Validators.required]),
      dateofbirth: new FormControl('', [Validators.required]),
      dateofaddmission:new FormControl('',[Validators.required])
    });

    
    this.active.paramMap.subscribe(parammap=>{
      this.adminservice.getStudentDetails(parseInt(parammap.get('rollno')),
          parammap.get('username')).subscribe((response:any)=>
      {
        if(response.status)
        {
          this.studentDetail=response.data;
          this.studentDetailsForm.patchValue(
            {
              rollNo:this.studentDetail.rollNo,
              name: this.studentDetail.name,
              fathername: this.studentDetail.fathername,
              username: this.studentDetail.username,
              studentclass: this.studentDetail.studentclass,
              age: this.studentDetail.age,
              address: this.studentDetail.address,
              phoneno:this.studentDetail.phoneno,
              dateofbirth:this.formatDate(this.studentDetail.dateofbirth[0], this.studentDetail.dateofbirth[1],this.studentDetail.dateofbirth[2]),
              dateofaddmission:this.formatDate(this.studentDetail.dateofaddmission[0], this.studentDetail.dateofaddmission[1],this.studentDetail.dateofaddmission[2])
            });
            
        }
      })
    });
  }

  private formatDate(yyyy:number,mm:number,dd:number) {
    let month = ''+mm;
    let day = '' + dd;
    const year = yyyy;
    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
    return [year, month, day].join('-');
  }

  get getControls() {
    return this.studentDetailsForm.controls;
  }

  updateStudent()
  {
    console.log(this.studentDetailsForm.value)
    this.adminservice.updateStudentDetails(this.studentDetailsForm.getRawValue()).subscribe((response:any)=>
    {
      alert(response.message);
      this.router.navigate(['/view-student-list'])
    });

  }


  deleteStudent()
  {
    console.log(this.studentDetailsForm.value)
    this.adminservice.deleteStudentDetails(this.getControls.rollNo.value,this.getControls.username.value)
    .subscribe((response:any)=>{
       alert(response.message);
       this.router.navigate(['/view-student-list'])
    });
  }

}
