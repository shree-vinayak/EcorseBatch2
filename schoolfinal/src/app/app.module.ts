import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './Auth/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginService } from './Services/login.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AdminHomeComponent } from './Admin/admin-home/admin-home.component';
import { StudentHomeComponent } from './Student/student-home/student-home.component';
import { AdminHeaderComponent } from './Admin/admin-header/admin-header.component';
import { StudentHeaderComponent } from './Student/student-header/student-header.component';
import { AdminService } from './Services/admin.service';
import { ViewStudentListComponent } from './Admin/view-student-list/view-student-list.component';
import { ViewStudentDetailsComponent } from './Admin/view-student-details/view-student-details.component';
import { StudentResultComponent } from './Admin/student-result/student-result.component';
import { BasicAuthHtppInterceptorServiceService } from './Services/basic-auth-htpp-interceptor-service.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminHomeComponent,
    StudentHomeComponent,
    AdminHeaderComponent,
    StudentHeaderComponent,
    ViewStudentListComponent,
    ViewStudentDetailsComponent,
    StudentResultComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [LoginService, AdminService,
    {  
      provide:HTTP_INTERCEPTORS, useClass:BasicAuthHtppInterceptorServiceService, multi:true 
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }
