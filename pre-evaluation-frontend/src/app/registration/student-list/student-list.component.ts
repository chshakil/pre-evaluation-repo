import { HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/service/student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  studentList: any = []

  constructor(
    private _studentService: StudentService
  ) { }

  ngOnInit(): void {
    this.getStudentList();
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

}
