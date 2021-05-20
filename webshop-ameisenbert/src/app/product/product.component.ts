import { Component, Input, OnInit } from '@angular/core';
import { product } from './product';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  constructor() { }

  @Input()
  product: product | undefined;

  ngOnInit(): void {
  }

}
