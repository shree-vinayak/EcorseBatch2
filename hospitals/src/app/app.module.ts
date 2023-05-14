import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { DatePipe, LocationStrategy, HashLocationStrategy } from '@angular/common';
import {MyInterceptorService} from'./utils/my-interceptor.service';
import{ExportExcelService} from './utils/export-excel.service';
import { FormatDatePipe } from './utils/format-date.pipe';
import { AdminHomeComponent } from './USERROLE/ADMIN/admin-home/admin-home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { AdminHeaderComponent } from './USERROLE/ADMIN/admin-header/admin-header.component';
import { AdminSidebarComponent } from './USERROLE/ADMIN/admin-sidebar/admin-sidebar.component';
import { FileReadComponent } from './file-read/file-read.component';
import { OldOpdComponent } from './USERROLE/ADMIN/old-opd/old-opd.component';
import { PatientRevisitTicketComponent } from './USERROLE/ADMIN/patient-revisit-ticket/patient-revisit-ticket.component';
import { DoctorWiseReportComponent } from './USERROLE/ADMIN/doctor-wise-report/doctor-wise-report.component';
import { PatientRevisitReportComponent } from './USERROLE/ADMIN/patient-revisit-report/patient-revisit-report.component';
import { BackupComponent } from './USERROLE/ADMIN/backup/backup.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FormatDatePipe,
    AdminHomeComponent,
    AdminHeaderComponent,
    AdminSidebarComponent,
    FileReadComponent,
    OldOpdComponent,
    PatientRevisitTicketComponent,
    DoctorWiseReportComponent,
    PatientRevisitReportComponent,
    BackupComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    BsDatepickerModule.forRoot(),
    HttpClientModule
  ],
  providers: [
    ExportExcelService,
    DatePipe,
    {
      provide:HTTP_INTERCEPTORS,
      useClass : MyInterceptorService,
      multi:true
    },
    {
      provide:LocationStrategy,
      useClass:HashLocationStrategy
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
