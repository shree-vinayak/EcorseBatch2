import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }


  public saveStudent(studentObj: any, ) {
    return this.http.post(environment.baseurl + 'saveStudentInfo', studentObj);

  }


  public getApi(url: string) {
    return this.http.get(environment.baseurl + url)
  }

  public getAllStuInfoOnSearchCriatria(searchFormValue: any) {
    return this.http.post(environment.baseurl + 'getStuInfoForSearchCriteria', searchFormValue)
  }


  public getStudentDetails(rollno: number, username: string) {

    return this.http.get(environment.baseurl + "getStudentDetails?rollno=" + rollno + "&&username=" + username);
  }

  public deleteStudentDetails(rollno: number, username: string) {
    const headers = new HttpHeaders().set('Authorization', sessionStorage.getItem('token'));

    return this.http.delete(environment.baseurl + "deleteStudentDetails?rollno=" + rollno + "&&username=" + username);
  }

  public updateStudentDetails(studentInfo: any) {

    return this.http.put(environment.baseurl + "updateStudentInfo", studentInfo);
  }

  public getClassesList() {

    return this.http.get<Number[]>(environment.baseurl + 'getClassesList');
  }


  public getResultForStudent(username: any) {
    return this.http.get(environment.baseurl + 'getStudentResult?username=' + username);
  }


  public saveResultForStudent(marksObj: any) {
    return this.http.post(environment.baseurl + 'saveStudentResult', marksObj);
  }
}
