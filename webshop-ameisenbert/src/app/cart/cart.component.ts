import { Component, OnInit } from '@angular/core';
import { HttpClientService } from 'src/app/services/http-client.service';
import { Cart } from './cart';
import { Product } from '../product/product';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  constructor(private httpservice: HttpClientService) { }
  
  cart: Cart | undefined;
  userID!: string | null;
  products: Product[] = [];

  ngOnInit(): void {
    this.userID = localStorage.getItem('userID');
    if (this.userID !== '-1' && this.userID)
      this.httpservice.cart(this.userID).subscribe((res) => {
        this.cart = <Cart>(<unknown>res);
        this.products = this.httpservice.productsByIDS(this.cart.productIDs as number[]);
      });;
  }

}
