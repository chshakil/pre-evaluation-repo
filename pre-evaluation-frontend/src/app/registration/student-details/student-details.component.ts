import { HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from 'src/app/classes/student';
import { StudentService } from 'src/app/service/student.service';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {

  student: Student = new Student();
  id: any;


  constructor(
    private _studentService: StudentService,
    private activateroute: ActivatedRoute,
    private router: Router

  ) {

  }

  ngOnInit(): void {
    this.id = this.activateroute.snapshot.params['id'];
    if(!this.id){
      this.router.navigate(['/student-grid-list']);
      return;
    }
    console.log('studentId',this.id);
    this.getStudentById();
  }

  getStudentById(){
    const params = new HttpParams().set('id', this.id );
    this._studentService.getStudentById(params).subscribe(
      res => {
        this.student = res;
        console.log(this.student);
      }
    )
  }


}
