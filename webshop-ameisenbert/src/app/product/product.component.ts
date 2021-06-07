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

  ngOnInit(): void {
  }

  deleteProduct(id: string) {
      console.log(id);
      console.log('Data is deleted - Result - ', this.apiService.delete(id));
    }
  

  constructor(private apiService: ApiService) { }

}
