import { Component, OnInit } from '@angular/core';
import { HttpClientService } from 'src/app/services/http-client.service';
import { Order } from '../order/order';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  orders: Order[] = [];

  constructor(private httpservice: HttpClientService) { }

  ngOnInit(): void {
    this.getAllOrders();
  }

  getAllOrders() {
    this.httpservice
      .orders()
      .subscribe((res) => {
        this.orders = <Order[]>(<unknown>res);
      });
  }

}
