import { Component, Input, OnInit } from '@angular/core';
import { Product } from './product';
import { ApiService } from '../services/api.service';


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {


  @Input()
  product: Product | undefined;
  @Input()
  canAddToCart: boolean = false;
  @Input()
  canRemoveFromCart: boolean = false;
  @Input()
  canRemoveFromDb: boolean = false;



  ngOnInit(): void {
  }

  deleteFromCart() {
    var id = String(this.product?.productID);
    console.log(id);
    console.log('Data is deleted - Result - ');
    this.apiService.put('carts/deleteFromCart/' + localStorage.getItem('userID'), id).subscribe(data => {
      console.log(data)
      window.location.reload();
    });
  }


  deleteFromDb() {
    var id = String(this.product?.productID);
    console.log(id);
    console.log('Data is deleted - Result - ');
    this.apiService.delete('products/'+id).subscribe(data => {
      console.log(data);
      window.location.reload();
    })
  }

  putInCart() {
    var id = String(this.product?.productID);
    this.apiService.put("carts/addToCart/" + localStorage.getItem('userID'), id).subscribe(data => {
      console.log(data);
    });
  }


  constructor(private apiService: ApiService) { }

}
