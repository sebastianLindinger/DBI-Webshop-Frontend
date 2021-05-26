import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../product/product';
import { Cart } from '../cart/cart';
import { Observable } from 'rxjs';
import { from } from 'rxjs';
import { tap } from 'rxjs/operators';



@Injectable({
  providedIn: 'root'
})
export class HttpClientService {
  authUrl = 'http://localhost:8080/ameisenbert.shop/';
  constructor(private http: HttpClient) { }

  products(): Observable<Product[]> {
    return this.http.get<Product[]>(this.authUrl + 'products');
  }

  productsByIDs(productIDs: number[]) : Observable<Product[]>{
    var products: Observable<Product[]> = from([]);
    for(var id of productIDs) {
        var product: Observable<Product> = this.http.get<Product>(this.authUrl + 'products/' + id);
        products.pipe(tap(usersList => {
          return usersList.push(product);
        }));
    }
    return products;
  }

  cart(userID: string | null): Observable<Cart> | undefined {
    return this.http.get<Cart>(this.authUrl + 'carts/byUser/' + userID);
  }
}
