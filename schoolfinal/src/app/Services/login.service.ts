import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }


  authenticate(loginObj: any): any {
    console.log('Login Service Called', loginObj);
    debugger;
    return this.http.post(environment.baseurl+'login?logintype='+loginObj.logintype, loginObj);
  }

  isUserLoggedIn(): boolean {
    let role = sessionStorage.getItem('role');
    let username = sessionStorage.getItem('username');
    if (role != null && role != undefined && username != null && username != undefined) {
      return true;
    }
    return false;
  }

  isAdminLoggedIn(): boolean {
    let role = sessionStorage.getItem('role');
    if (role === 'ADMIN') {
      return true;
    }
    return false;
  }

  isStudentLoggedIn() {
    let role = sessionStorage.getItem('role');
    if (role === 'STUDENT') {
      return true;
    }
    return false;
  }

  
}
