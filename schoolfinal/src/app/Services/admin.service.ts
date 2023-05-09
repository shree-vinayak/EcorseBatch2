import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }


  public saveStudent(studentObj: any,) {
    return this.http.post('http://localhost:8080/spring_configuration1/saveStudentInfo', studentObj);
  }


  public getAllStudentInfo()
  {
    return this.http.get('http://localhost:8080/spring_configuration1/getAllStudentInfo')
  }

  getAllStuInfoOnSearchCriatria(searchFormValue:any)
  {
    return this.http.post('http://localhost:8080/spring_configuration1/getStuInfoForSearchCriteria',searchFormValue)
  }
  
}
