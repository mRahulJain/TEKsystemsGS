import { Users } from './../../model/users';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Message } from 'src/app/model/message';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private baseURL = 'http://localhost:9090';

  constructor(private http: HttpClient) { }

  putUser(user: Users) : Observable<Message> {
    let targetURL = '/users/addUser'
    return this.http.post<Message>(this.baseURL+targetURL, user);
  }
}
