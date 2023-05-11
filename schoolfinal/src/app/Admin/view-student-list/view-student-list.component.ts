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

}
