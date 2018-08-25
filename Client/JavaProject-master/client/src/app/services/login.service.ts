import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  login(email: string, password: string, clientType: string): Observable<any> {
    return this.http.get("/api/login", {
      params: {
        "email": email,
        "password": password,
        "client-type": clientType
      },
      responseType: 'text'
    })
  }

  logout() {
    return this.http.get("/api/logoff", {responseType: 'text'})
  }
}
