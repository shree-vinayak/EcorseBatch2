import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FileReadComponent } from './file-read/file-read.component';
import { LoginComponent } from './login/login.component';
import { AdminAgentDurationWiseReportComponent } from './USERROLE/ADMIN/admin-agent-duration-wise-report/admin-agent-duration-wise-report.component';
import { AdminAgentWiseAllCallReportComponent } from './USERROLE/ADMIN/admin-agent-wise-all-call-report/admin-agent-wise-all-call-report.component';
import { AdminAgentWiseParkCallComponent } from './USERROLE/ADMIN/admin-agent-wise-park-call/admin-agent-wise-park-call.component';
import { AdminHomeComponent } from './USERROLE/ADMIN/admin-home/admin-home.component';
import { OldOpdComponent } from './USERROLE/ADMIN/old-opd/old-opd.component';
import { PatientRevisitTicketComponent } from './USERROLE/ADMIN/patient-revisit-ticket/patient-revisit-ticket.component';
import { DoctorWiseReportComponent } from './USERROLE/ADMIN/doctor-wise-report/doctor-wise-report.component';
import { PatientRevisitReportComponent } from './USERROLE/ADMIN/patient-revisit-report/patient-revisit-report.component';
import { BackupComponent } from './USERROLE/ADMIN/backup/backup.component';
import { NewOpdReportComponent } from './USERROLE/ADMIN/new-opd-report/new-opd-report.component';
import { RevisitReportComponent } from './USERROLE/ADMIN/revisit-report/revisit-report.component';
import { SpHomeComponent } from './USERROLE/SUPERADMIN/sp-home/sp-home.component';
import { SpDoctorOPSComponent } from './USERROLE/SUPERADMIN/sp-doctor-ops/sp-doctor-ops.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'file/:data', component: FileReadComponent },
  { path: 'admin-home', component: AdminHomeComponent },
  { path: 'old-opd', component: OldOpdComponent },
  {path:'new-opd-report',component:NewOpdReportComponent},
  {path:'revisit-report',component:RevisitReportComponent},
  { path: 'patient-revisit-ticket/:data', component: PatientRevisitTicketComponent },
  { path: 'doctor-wise-report', component: DoctorWiseReportComponent },
  { path: 'doctor-wise-report-revisit', component: PatientRevisitReportComponent },
  { path: 'backup', component: BackupComponent },

  //super admin routes
  {path:'sp-home',component:SpHomeComponent},
  {path:'doctor-ops',component:SpDoctorOPSComponent},
  // agent wise reports
  { path: 'admin-agent-wise-park-call', component: AdminAgentWiseParkCallComponent },
  { path: 'admin-agent-wise-all-call-report', component: AdminAgentWiseAllCallReportComponent },
  { path: 'admin-agent-duration-wise-report', component: AdminAgentDurationWiseReportComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
