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
import { AdminHeaderComponent } from './Admin/admin-header/admin-header.component';
import { StudentHeaderComponent } from './Student/student-header/student-header.component';
import { AdminService } from './Services/admin.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminHomeComponent,
    StudentHomeComponent,
    AdminHeaderComponent,
    StudentHeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [LoginService, AdminService],
  bootstrap: [AppComponent]
})
export class AppModule { }
