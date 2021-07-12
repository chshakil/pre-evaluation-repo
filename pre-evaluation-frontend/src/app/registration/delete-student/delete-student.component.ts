import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Student } from 'src/app/classes/student';
import { StudentService } from 'src/app/service/student.service';

@Component({
  selector: 'app-delete-student',
  templateUrl: './delete-student.component.html',
  styleUrls: ['./delete-student.component.css']
})
export class DeleteStudentComponent implements OnInit {

  student: Student = new Student();
  studentId: any;

  constructor(
    private _studentService: StudentService,
    private activeRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    
  }

}
