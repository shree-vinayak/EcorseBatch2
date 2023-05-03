import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './Auth/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginService } from './Services/login.service';
import { HttpClientModule } from '@angular/common/http';
import { AdminHomeComponent } from './Admin/admin-home/admin-home.component';
import { StudentHomeComponent } from './Student/student-home/student-home.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminHomeComponent,
    StudentHomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
