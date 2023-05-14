import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SessionStorageService } from 'angular-web-storage';
import { environment } from 'src/environments/environment';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.css']
})
export class AdminHeaderComponent implements OnInit {
  userrole: string;
  username: string;
  showModel: boolean = false;
  submitted: boolean = false;
  loader: boolean = false;
  loginid: string = null;

  changePasswordResp: any;


  passwordChangeForm: FormGroup;
  constructor(private session: SessionStorageService,
    private router: Router,
    private fb: FormBuilder,
    private http: HttpClient) { }

  ngOnInit() {
    if (this.session.get("flag") === true) {

      this.userrole = this.session.get('userrole');
      this.username = this.session.get('username');
      this.passwordChangeForm = this.fb.group({
        password: ['', Validators.required],
        newPassword: ['', Validators.required]
      });

    } else {
      this.router.navigate(['/login']);
    }
  }

  get f1() {
    return this.passwordChangeForm.controls;
  }

  logout() {
    if (this.session.get("username") != null) {
      this.session.remove("userrole");
      this.session.remove("username");
      this.session.remove("flag");
      this.session.remove('token')
      this.session.remove("loginid");

      this.router.navigate(['/login']);

    } else {
      this.session.remove("token");
      this.session.remove("userrole");
      this.session.remove("username");
      this.session.remove("flag");
      this.session.remove("loginid");

      this.router.navigate(['/login']);
    }
  }

  showChangePasswordModel() {
    this.showModel = true;


  }

  submitForm() {
    this.loader = true;
    this.submitted = true;

    if (this.passwordChangeForm.invalid) {
      this.loader = false;
      return;
    }

    let formdata = new FormData();
    this.loginid = this.session.get('loginid');
    formdata.append('loginid',this.loginid);
    formdata.append('oldpass',this.passwordChangeForm.value.password);
    formdata.append('newpass',this.passwordChangeForm.value.newPassword);


    return this.http.post(environment.url + "system-login/change-password", formdata).subscribe(response => {
      this.changePasswordResp = response;

      if (this.changePasswordResp.flag === true) {
        Swal.fire({
          icon: 'success',
          // title: 'Pass',
          text: 'Changed Successfully.',
          showConfirmButton: false,
          timer: 2000
          // footer: '<a href="">Why do I have this issue?</a>'
        });
        this.change();
        this.loader = false;
      } else {
        Swal.fire({
          icon: 'info',
          // title: 'Pass',
          text: 'Old Password Not Matched.',
          showConfirmButton: false,
          timer: 2000
          // footer: '<a href="">Why do I have this issue?</a>'
        });
        this.change();
        this.loader = false;
      }
    },
      error => {
        this.loader = false;
        // alert('Server not responding');
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Something went wrong!',
          showConfirmButton: false,
          timer: 3000
          // footer: '<a href="">Why do I have this issue?</a>'
        });

      });

  }

  change() {
    this.showModel = false;
    this.passwordChangeForm.reset();
    this.submitted = false;

  }

}
