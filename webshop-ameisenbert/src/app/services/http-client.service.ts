import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {
  authUrl = 'http://localhost:8080/ameisenbert.shop/';
  constructor(private http: HttpClient) { }
  products(){
    return this.http.get(this.authUrl + 'products');
  }
}
