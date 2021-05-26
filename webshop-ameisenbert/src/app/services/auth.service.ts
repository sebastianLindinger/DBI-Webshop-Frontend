import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  authUrl = 'http://localhost:8080/ameisenbert.shop/';

  constructor(private http: HttpClient, private apiService: ApiService) { }

  login(model: any) {
    return this.apiService.post('users/login', model);
  }
}
