import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/Services/admin.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import {  Router } from '@angular/router';

@Component({
  selector: 'app-view-student-list',
  templateUrl: './view-student-list.component.html',
  styleUrls: ['./view-student-list.component.css']
})
export class ViewStudentListComponent implements OnInit {
  searchForm:FormGroup=null;

  studentList:any=null;
  constructor(private adminService:AdminService,private route:Router) { }


  columns:string[]=['rollNo','name','username','age'];
  selectedColumns:string[]=[];

  AddColumnValue(index:number)
  {
    console.log('selected index',index);
    this.selectedColumns.push(this.columns[index]);
  }

  ngOnInit() {

    this.searchForm= new FormGroup({
      name:new FormControl(),
      username:new FormControl(),
      studentclass:new FormControl(),
      selectedColumnsValue:new FormControl()
    })
 
    

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

  submitForm()
  {
    this.studentList=null;
    this.searchForm.controls.selectedColumnsValue.patchValue(this.selectedColumns);
    this.adminService.getAllStuInfoOnSearchCriatria(this.searchForm.value).subscribe((response:any)=>
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


  navigateToStudenDetails(studentInfo:any)
  {
    this.route.navigate(['/view-studentdetails',studentInfo.rollNo,studentInfo.username]);

  }

  public formatDate(value:number[]):string {
    let month = ''+value[1];
    let day = '' + value[2];
    const year =  value[0];
    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
    return [year, month, day].join('-');
  }

}
