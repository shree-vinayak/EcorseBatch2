import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { LoginService } from 'src/app/Services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup = null;
  submitted: boolean = false;

  constructor(private loginservice: LoginService) { }

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
    let response = this.loginservice.authenticate(this.loginForm.value);
    console.log('response', response);
    //Service
  }

}
