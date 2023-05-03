import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }


  authenticate(loginObj: any): any {
    console.log('Login Service Called', loginObj);
    return this.http.post('http://localhost:8080/spring_configuration1/login', loginObj);
  }





}
