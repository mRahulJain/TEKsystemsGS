import { Users } from './../../model/users';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Message } from 'src/app/model/message';
import { ChequeBooks } from 'src/app/model/cheque-books';

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

  checkUserByIdAndPassword(loginUserId: string, loginUserPassword: string) : Observable<Message> {
    let targetURL = `/users/check/${loginUserId}/${loginUserPassword}`;
    return this.http.get<Message>(this.baseURL+targetURL);
  }

  getUser(loginUserId: string) : Observable<Users> {
    return this.http.get<Users>(`${this.baseURL}/users/${loginUserId}`);
  }

  updateLoginPassword(newPassword: string, accountNumber: string) {
    return this.http.get<Message>(`${this.baseURL}/users/update/loginPassword/${newPassword}/${accountNumber}`)
  }

  updateTransactionPassword(newPassword: string, accountNumber: string) {
    return this.http.get<Message>(`${this.baseURL}/users/update/transactionPassword/${newPassword}/${accountNumber}`)
  }

  requestChequeBook(accountNumber: string) {
    return this.http.get<Message>(`${this.baseURL}/users/request-cheque-book/${accountNumber}`)
  }

  getChequeBooks(accountNumber: string) : Observable<Array<ChequeBooks>> {
    return this.http.get<Array<ChequeBooks>>(`${this.baseURL}/users/cheque-books/${accountNumber}`);
  }

  getAllChequeBookRequests() : Observable<Array<ChequeBooks>> {
    return this.http.get<Array<ChequeBooks>>(`${this.baseURL}/admin/cheque-books-requests`);
  }

  acceptChequeBookRequest(chequeBookNumber: string) : Observable<Message> {
    return this.http.get<Message>(`${this.baseURL}/admin/cheque-books-requests/accept/${chequeBookNumber}`);
  }
}
