import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../classes/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  // baseUrl: string = "http://localhost:8080/api/student/";


  private SAVE_STUDENT_URL = `http://localhost:8080/api/student/save-student`;
  private UPDATE_STUDENT_URL = `http://localhost:8080/api/student/update-student`;
  private DELETE_STUDENT_URL = `http://localhost:8080/api/student/delete-student-by-id`;
  private GET_STUDENT_LIST_URL = `http://localhost:8080/api/student/get-student-list`;
  private GET_STUDENT_BY_ID_URL = `http://localhost:8080/api/student/get-student-by-id`;

  constructor(
    private http: HttpClient
  ) { }

  saveStudent(student: Student): Observable<any> {
    return this.http.post<any>(this.SAVE_STUDENT_URL, student);
  }


  updateStudent(student: any): Observable<any> {
    return this.http.put<any>(this.UPDATE_STUDENT_URL, student);
  }

  // updateStudent(id: any, student: any): Observable<any> {
  //   return this.http.put<any>(`${this.updateUrl}/${id}`, student);
  // }

  deleteStudentById(params: any): Observable<any> {
    return this.http.delete<any>(this.DELETE_STUDENT_URL, { params });
  }

  // deleteStudentById(id: any): Observable<any> {
  //   return this.http.delete<any>(`${this.deleteUrl}/${id}`);
  // }
  getStudentList(student: any): Observable<any> {
    return this.http.get<any>(this.GET_STUDENT_LIST_URL, student);
  }

  getStudentById(params: any): Observable<any> {
    return this.http.get<any>(this.GET_STUDENT_BY_ID_URL, { params });
  }

}
