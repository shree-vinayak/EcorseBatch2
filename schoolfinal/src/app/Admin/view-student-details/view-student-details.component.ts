import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdminService } from 'src/app/Services/admin.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-view-student-details',
  templateUrl: './view-student-details.component.html',
  styleUrls: ['./view-student-details.component.css']
})
export class ViewStudentDetailsComponent implements OnInit {

  studentDetail:any=null;

  studentDetailsForm:FormGroup=null;
  
  constructor(private active:ActivatedRoute,private admin:AdminService) { }
  ngOnInit() {
    this.active.paramMap.subscribe(parammap=>{
      this.admin.getStudentDetails(parseInt(parammap.get('rollno')),parammap.get('username')).subscribe((response:any)=>
      {
        
        if(response.status)
        {
          this.studentDetail=response.data;
         
        }

      })

    });

   



  }

}
