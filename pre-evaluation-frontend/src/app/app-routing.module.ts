import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddStudentComponent } from './registration/add-student/add-student.component';
import { DeleteStudentComponent } from './registration/delete-student/delete-student.component';
import { StudentDataTableComponent } from './registration/student-data-table/student-data-table.component';
import { StudentDetailsComponent } from './registration/student-details/student-details.component';
import { StudentListComponent } from './registration/student-list/student-list.component';
import { UpdateComponent } from './registration/update/update.component';

const routes: Routes = [
  { path: '', redirectTo: '/student-grid-list', pathMatch: 'full' },
  { path: 'add-student', component: AddStudentComponent },
  { path: 'student-list', component: StudentListComponent },
  { path: 'edit-student/:id', component: UpdateComponent },
  { path: 'student-grid-list', component: StudentDataTableComponent },
  { path: 'delete-student', component: DeleteStudentComponent },
  { path: 'student-details/:id', component: StudentDetailsComponent },
  { path: '**', redirectTo: '/student-grid-list' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
