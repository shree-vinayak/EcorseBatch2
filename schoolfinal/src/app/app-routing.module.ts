import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './Auth/login/login.component';
import { AdminHomeComponent } from './Admin/admin-home/admin-home.component';
import { StudentHomeComponent } from './Student/student-home/student-home.component';


const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },

  // PATH FOR ADMIN  START 
  { path: 'admin-home', component: AdminHomeComponent },

  // PATH FOR STUDENT START
  { path: 'student-home', component: StudentHomeComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
