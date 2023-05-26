import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AdminService } from 'src/app/Services/admin.service';
import { crossfieldValidators } from 'src/app/validators/crossfield.validator';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {



  adminValidation: FormGroup = null;
  submitted: boolean = false;

  constructor(private adminService: AdminService) { }

  ngOnInit() {
    this.adminValidation = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.minLength(3), Validators.pattern("^[a-zA-Z]+$")]),
      fathername: new FormControl('', [Validators.required, Validators.minLength(3), Validators.pattern("^[a-zA-Z]+$")]),
      username: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required]),
      confirmpassword: new FormControl('', [Validators.required]),
      studentclass: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),
      phoneno: new FormControl('', [Validators.required]),
      dateofbirth: new FormControl('', [Validators.required]),
    },crossfieldValidators);
  }

  get getControls() {
    return this.adminValidation.controls;
  }

  submitForm() {

    console.log('formGroup Object', this.adminValidation);
    console.log('Object value', this.adminValidation.value);
    this.submitted = false;
    if (this.adminValidation.invalid) {
      this.submitted = true;
      return
    }

    this.adminService.saveStudent(this.adminValidation.value).subscribe((response: any) => {
      if(response.status)
      {
        this.adminValidation.reset();

      }
      else{
        alert(response.message);
      }
    })


  }

}
