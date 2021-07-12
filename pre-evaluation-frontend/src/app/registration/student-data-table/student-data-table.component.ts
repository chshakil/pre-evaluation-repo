import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Subject } from 'rxjs';
import { StudentService } from 'src/app/service/student.service';
import { DataTableDirective } from 'angular-datatables';
import { Router } from '@angular/router';
import { Student } from 'src/app/classes/student';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-student-data-table',
  templateUrl: './student-data-table.component.html',
  styleUrls: ['./student-data-table.component.css']
})
export class StudentDataTableComponent implements OnInit, OnDestroy {
  studentList: any = [];
  selecetedStudent: any = {};

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject<any>();

  @ViewChild(DataTableDirective, { static: false })
  datatableElement: any = DataTableDirective;

  min: any = 0;
  max: any = 10;

  constructor(
    private _studentService: StudentService,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {

    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      processing: true,
    };
    this.getStudentList();



    $.fn.dataTable.ext.search.push((settings: any, data: string[], dataIndex: any) => {
      const id = parseFloat(data[0]) || 0; // use data for the id column
      return (Number.isNaN(this.min) && Number.isNaN(this.max)) ||
        (Number.isNaN(this.min) && id <= this.max) ||
        (this.min <= id && Number.isNaN(this.max)) ||
        (this.min <= id && id <= this.max);
    });
  }

  //a function to filter the data table by id
  filterById(): void {
    this.datatableElement.dtInstance.then((dtInstance: DataTables.Api) => {
      dtInstance.draw();
    });
  }

  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();

    $.fn.dataTable.ext.search.pop();
  }

  getStudentList() {
    const params = new HttpParams;
    this._studentService.getStudentList(params).subscribe(
      res => {
        this.studentList = res;
        console.log(res);
        this.dtTrigger.next();
      }
    )
  }

  addStudent() {
    this.router.navigate(['/add-student']);
  }

  editStudent() {
    if (!this.selecetedStudent || !this.selecetedStudent.id){
      this.toastr.warning('Please Select a Student.', 'Warning')
      return;
    }
    this.router.navigate(['/edit-student/' + this.selecetedStudent.id]);
  }

  detailsStudent(){
    if (!this.selecetedStudent || !this.selecetedStudent.id){
      this.toastr.warning('Please Select a Student.', 'Warning')
      return;
    }
    this.router.navigate(['/student-details/' + this.selecetedStudent.id]);
  }

  deleteStudent() {
    if (!this.selecetedStudent || !this.selecetedStudent.id){
      this.toastr.warning('Please Select a Student.', 'Warning')
      return;
    }
    const params = new HttpParams().set('id',this.selecetedStudent.id);
      this._studentService.deleteStudentById(params).subscribe(
        res => {
          this.toastr.warning(res, 'Success');
          this.getStudentList();
        },
        error => {
          this.getStudentList();
          // this.toastr.error(error, 'Error');
        }
      )
  }


  selectStudent(student: any) {
    this.selecetedStudent = student;
  }



}
