import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }


  public saveStudent(studentObj: any,) {
    return this.http.post(environment.baseurl+'saveStudentInfo', studentObj);

  }


  public getAllStudentInfo()
  {
    return this.http.get(environment.baseurl+'getAllStudentInfo')
  }

  getAllStuInfoOnSearchCriatria(searchFormValue:any)
  {
    return this.http.post(environment.baseurl+'getStuInfoForSearchCriteria',searchFormValue)
  }
  
}
