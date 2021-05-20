import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { product } from '../product/product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {
  authUrl = 'http://localhost:8080/ameisenbert.shop/';
  constructor(private http: HttpClient) { }

  products() : Observable<product[]> {
    return this.http.get<product[]>(this.authUrl + 'products');
  }
}
