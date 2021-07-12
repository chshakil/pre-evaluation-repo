import { HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AcademicQual } from 'src/app/classes/academic-qual';
import { Student } from 'src/app/classes/student';
import { StudentService } from 'src/app/service/student.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  student: Student = new Student();
  id: any;


  constructor(
    private _studentService: StudentService,
    private activateroute: ActivatedRoute,
    private router: Router,
    private toastr: ToastrService

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

  updateStudent(){
    this._studentService.updateStudent(this.student).subscribe(
      res => {
        this.student = res;
        if(res){
          this.toastr.success('Student Registration Update Successfull.', 'Success');
          this.router.navigate(['/student-grid-list']);
        }
        console.log(this.student);
      },err=>{
        this.toastr.error(err, 'Error');
      }
    )
  }

  addAcademicQual(){
    this.student.academicQualList.push(new AcademicQual());
  }

}

