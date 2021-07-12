import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddStudentComponent } from './registration/add-student/add-student.component';
import { StudentListComponent } from './registration/student-list/student-list.component';
import { FormsModule } from '@angular/forms';
import { StudentService } from './service/student.service';
import { UpdateComponent } from './registration/update/update.component';
import { StudentDataTableComponent } from './registration/student-data-table/student-data-table.component';
import { DataTablesModule } from 'angular-datatables';
import { DeleteStudentComponent } from './registration/delete-student/delete-student.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { ToastrModule } from 'ngx-toastr';
import { StudentDetailsComponent } from './registration/student-details/student-details.component';
@NgModule({
  declarations: [
    AppComponent,
    AddStudentComponent,
    StudentListComponent,
    UpdateComponent,
    StudentDataTableComponent,
    DeleteStudentComponent,
    StudentDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    DataTablesModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
  ],
  providers: [StudentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
