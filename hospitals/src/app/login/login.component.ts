import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Router } from '@angular/router';
import { SessionStorageService } from 'angular-web-storage';
import { environment }  from '../../environments/environment';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginid: string;
  password: string;
  resp: any;
  uid: string;
  upass: string
  constructor(private http: HttpClient,
    private router: Router,
    private session: SessionStorageService,
    ) { }

  ngOnInit(): void {
  }
  loginAll(){
    if (this.loginid != null && this.password != null) {
      let formdata: FormData = new FormData();

      formdata.append("loginid",this.loginid);
      formdata.append("password",this.password);


      this.http.post(environment.url + "hospitals/login", formdata).subscribe(
        response => {
          this.resp = response;
          if (this.resp.flag===true) {
            this.session.set("token", "HOSPITALS " + this.resp.token);
            this.session.set("role", this.resp.role);
            this.session.set("flag", this.resp.flag);
            this.session.set("loginid", this.loginid);
            this.router.navigate(['/admin-home']);
          }
          else {
            alert(this.resp.msg);
          }

        });
    } else {
      alert("Login Id and Password is null!!")
    }
  }
}
