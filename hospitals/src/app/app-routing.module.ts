import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FileReadComponent } from './file-read/file-read.component';
import { LoginComponent } from './login/login.component';
import { AdminHomeComponent } from './USERROLE/ADMIN/admin-home/admin-home.component';
import { OldOpdComponent } from './USERROLE/ADMIN/old-opd/old-opd.component';
import { PatientRevisitTicketComponent } from './USERROLE/ADMIN/patient-revisit-ticket/patient-revisit-ticket.component';
import { DoctorWiseReportComponent } from './USERROLE/ADMIN/doctor-wise-report/doctor-wise-report.component';
import { PatientRevisitReportComponent } from './USERROLE/ADMIN/patient-revisit-report/patient-revisit-report.component';
import { BackupComponent } from './USERROLE/ADMIN/backup/backup.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'file/:data', component: FileReadComponent },
  { path: 'admin-home', component: AdminHomeComponent },
  { path: 'old-opd', component: OldOpdComponent },
  { path: 'patient-revisit-ticket/:data', component: PatientRevisitTicketComponent },
  { path: 'doctor-wise-report', component: DoctorWiseReportComponent },
  { path: 'doctor-wise-report-revisit', component: PatientRevisitReportComponent },
  { path: 'backup', component: BackupComponent },
  // agent wise reports

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
