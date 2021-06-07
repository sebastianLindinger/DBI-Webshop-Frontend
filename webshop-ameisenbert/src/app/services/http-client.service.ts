import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiService } from '../services/api.service';
import { Product } from '../product/product';

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {
  constructor(private http: HttpClient, private apiService: ApiService) { }

  products() {
    return this.apiService.get('products');
  }

  productsByIDS(productIDs: number[]) {
    var products: Product[] = [];
    for (var id of productIDs) {
      this.apiService.get('products/' + id).subscribe(res =>
        products.push(<Product>(<unknown>res))
      );
    }
    return products;
  }

  cart(userID: string | null) {
    return this.apiService.get('carts/byUser/' + userID);
  }

  orders() {
    return this.apiService.get('orders');
  }

  register(model: any) {
    console.log(model)
    return this.apiService.post('users', model);
  }

  createCartForUser(userID: any) {
    console.log(userID);
    return this.apiService.post('carts', { userID: userID, productIDs: [] })
  }
}
