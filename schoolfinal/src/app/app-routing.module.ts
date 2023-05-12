import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './Auth/login/login.component';
import { AdminHomeComponent } from './Admin/admin-home/admin-home.component';
import { StudentHomeComponent } from './Student/student-home/student-home.component';
import { ViewStudentListComponent } from './Admin/view-student-list/view-student-list.component';
import { ViewStudentDetailsComponent } from './Admin/view-student-details/view-student-details.component';


const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },

  // PATH FOR ADMIN  START 
  { path: 'admin-home', component: AdminHomeComponent },
  {path:'view-student-list',component:ViewStudentListComponent},
  {path:'view-studentdetails/:rollno/:username',component:ViewStudentDetailsComponent},

  // PATH FOR STUDENT START
  { path: 'student-home', component: StudentHomeComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
