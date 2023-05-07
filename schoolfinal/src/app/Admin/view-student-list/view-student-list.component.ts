import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/Services/admin.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-view-student-list',
  templateUrl: './view-student-list.component.html',
  styleUrls: ['./view-student-list.component.css']
})
export class ViewStudentListComponent implements OnInit {
  searchForm:FormGroup=null;

  studentList:any=null;
  constructor(private adminService:AdminService) { }

  ngOnInit() {
 
    

    this.adminService.getAllStudentInfo().subscribe((response:any)=>
    {
        if(response.status)
        {
          this.studentList= response.data; 
          console.log(this.studentList);
        }
        else{
          alert(response.message);
        }
    });

  }

}
