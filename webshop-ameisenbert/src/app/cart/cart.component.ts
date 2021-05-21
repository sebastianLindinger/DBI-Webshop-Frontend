import { Component, OnInit } from '@angular/core';
import { HttpClientService } from 'src/app/services/http-client.service';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  constructor(private httpservice: HttpClientService) { }

  userID = localStorage.getItem('userID');
  cart = this.httpservice.cart(this.userID);  
  products = this.httpservice.productsByIDs(this.cart?.subscribe(val => val.productIDs));
  ngOnInit(): void {
  }

}
