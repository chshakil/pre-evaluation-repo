import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { data } from 'jquery';
import { ToastrService } from 'ngx-toastr';
import { AcademicQual } from 'src/app/classes/academic-qual';
import { Address } from 'src/app/classes/address';
import { Student } from 'src/app/classes/student';
import { StudentService } from 'src/app/service/student.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  student: Student = new Student();
  submitted = false;

  constructor(
    private studentService: StudentService,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.student.academicQualList.push(new AcademicQual());
  }

  register() {
    this.submitted = true;
    this.studentService.saveStudent(this.student).subscribe(
      res => {
        console.log(res);
        this.student = new Student();
        this.router.navigate(['/student-grid-list']);
        this.toastr.success('Student Registration Successfull.', 'Success');
        console.log("Saved Data");
      },
      error => {
        this.toastr.error(error, 'Error');
        console.log(error);
      }
    )
  }

  addAcademicQual(){
    this.student.academicQualList.push(new AcademicQual());
  }

}
