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
    this.http.post(this.authUrl + "users/login", model).subscribe((data) => {
      console.log(data);
      localStorage.setItem('userID', data as string);
    })
  }
}
