import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { LoginService } from 'src/app/Services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup = null;
  submitted: boolean = false;

  constructor(private loginservice: LoginService,
    private router: Router) { }

  ngOnInit() {
    this.loginForm = new FormGroup({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])
    });
  }

  submitForm() {
    console.log('submit form called')
    this.submitted = false;
    if (this.loginForm.invalid) {
      this.submitted = true;
      alert('Username And Password Is Required.')
      return;
    }
    this.loginservice.authenticate(this.loginForm.value).subscribe((response: any) => {
      debugger
      if (response.status) {
        if (response.data.role === 'ADMIN') {
          sessionStorage.setItem('role', response.data.role);
          sessionStorage.setItem('username', response.data.username);
          this.router.navigate(['admin-home']);
        }
        else {
          sessionStorage.setItem('role', response.data.role);
          sessionStorage.setItem('username', response.data.username);
          this.router.navigate(['student-home'])
        }
      }
      else {
        alert(response.message);
      }
    });

  }

}
