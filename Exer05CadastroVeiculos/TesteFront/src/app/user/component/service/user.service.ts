import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserModel } from '../model/user.model';

//const baseUrl = '/v';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly API = 'http://localhost:8080/veiculos';

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<any>{
    return this.httpClient.get(this.API);
  }

  save(user: UserModel): Observable<UserModel>{
    return this.httpClient.post<UserModel>(`${this.API}/cadastro`, user);
  }
}
