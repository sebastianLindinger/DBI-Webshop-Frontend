import { Component, Input, OnInit } from '@angular/core';
import { HttpClientService } from '../services/http-client.service';
import { Order } from './order';
import { Product } from '../product/product';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  @Input()
  order: Order | undefined;
  products: Product[] = [];

  constructor(private httpservice: HttpClientService) { }

  ngOnInit(): void {
    this.getAllProductsOfOrder();
  }

  getAllProductsOfOrder() {
    this.products = this.httpservice.productsByIDS(this.order?.productIDs as number[]);
  }

}
