import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  authUrl = 'http://localhost:8080/ameisenbert.shop/';

  constructor(private http: HttpClient) { }

  login(model: any) {
    console.log(model);
  }
}
