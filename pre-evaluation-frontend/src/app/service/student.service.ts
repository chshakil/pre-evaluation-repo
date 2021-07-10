import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private SAVE_STUDENT_URL = `http://localhost:8080/api/student/save-student`;
  private UPDATE_STUDENT_URL = `http://localhost:8080/api/student/update-student`;
  private DELETE_STUDENT_URL = `http://localhost:8080/api/student/delete-studentBy-id/`;
  private GET_STUDENT_LIST_URL = `http://localhost:8080/api/student/get-student-list`;

  constructor(
    private http: HttpClient
  ) { }

  saveStudent(param: any): Observable<any> {
    return this.http.post<any>(this.SAVE_STUDENT_URL, param);
  }
  updateStudent(param: any): Observable<any> {
    return this.http.put<any>(this.UPDATE_STUDENT_URL, param);
  }
  deleteStudent(param: any): Observable<any> {
    return this.http.delete<any>(this.DELETE_STUDENT_URL, param);
  }
  getStudentList(param: any): Observable<any> {
    return this.http.get<any>(this.GET_STUDENT_LIST_URL, param);
  }

}
