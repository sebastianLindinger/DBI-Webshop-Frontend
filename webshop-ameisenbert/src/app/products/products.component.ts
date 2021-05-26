import { Component, OnInit } from '@angular/core';
import { HttpClientService } from 'src/app/services/http-client.service';
import { Product } from '../product/product'

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  constructor(private httpservice: HttpClientService) { }

  products: Product[] = [];

  ngOnInit(): void {
    this.getAllProducts();
  }

  getAllProducts() {
    this.httpservice
      .products()
      .subscribe((res) => {
        this.products = <Product[]>(<unknown>res);
      });
  }
}
