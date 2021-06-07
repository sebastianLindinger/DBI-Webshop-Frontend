import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  readonly ROOT_URL;

  constructor(private http:HttpClient) {
    this.ROOT_URL = 'http://localhost:8080/ameisenbert.shop'
  }

  get(url: string){
    return this.http.get(`${this.ROOT_URL}/${url}`);
  }

  put(url: string, payload: Object ){
    const  headers = new HttpHeaders(
      {
        'Content-Type': 'application/json' as const
    });
    console.log(`${this.ROOT_URL}/${url}`)
    console.log(payload)
    return this.http.put(`${this.ROOT_URL}/${url}`, payload, {headers: headers});
  }

  post(url: string, payload: Object){
    const  headers = new HttpHeaders(
      {
        'Content-Type': 'application/json' as const
    });
    console.log(`${this.ROOT_URL}/${url}`)
    console.log(payload)
    return this.http.post(`${this.ROOT_URL}/${url}`, payload, {headers: headers});
  }

  delete(url: string){
    console.log('delete method '+`${this.ROOT_URL}/${url}`);
    return this.http.delete(`${this.ROOT_URL}/${url}`);
  }
}