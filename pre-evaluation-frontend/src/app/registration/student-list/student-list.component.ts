import { HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AcademicQual } from 'src/app/classes/academic-qual';
import { Address } from 'src/app/classes/address';
import { Student } from 'src/app/classes/student';
import { StudentService } from 'src/app/service/student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  studentList: any = [];
  selectedStudent: any;

  constructor(
    private _studentService: StudentService,
    private route: Router
  ) {

  }

  ngOnInit(): void {
    this.getStudentList();
  }

  editStudent() {
    if (!this.selectedStudent) {
      alert('Please select a Student.')
      return;
    }
    this.route.navigate(['/edit-student/' + this.selectedStudent.id]);
  }

  detailsStudent() {
    if (!this.selectedStudent) {
      alert('Please select a Student.')
      return;
    }
    this.route.navigate(['/student-details/' + this.selectedStudent.id]);
  }

  

  clickStudent(student: Student) {
    console.log('student', student);

    this.selectedStudent = student;
  }

  getStudentList() {
    const params = new HttpParams;
    this._studentService.getStudentList(params).subscribe(
      res => {
        this.studentList = res;
        console.log(res);
      }
    )
  }

  deleteStudent(id: number) {
    const params = new HttpParams;
    this._studentService.deleteStudentById(id).subscribe(
      res => {
        this.studentList = res;
        console.log(res);
      }
    )
  }


}
