import { Component, Input } from '@angular/core';
import { HttpClientService } from '../services/http-client.service';
import { Product } from '../product/product';


@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {
  /** Based on the screen size, switch from standard to one column per row */
  products: Product[] = [];

  @Input() deviceXs: boolean | undefined;

  
  ngOnDestroy() {
    this.products = [];
  }

  getAllProducts() {
    this.httpservice
      .products()
      .subscribe((res) => {
        console.log(res);
        this.products = [];
        this.products = <Product[]>(<unknown>res);
      });
  }

  ngOnInit(): void {
    console.log("on init")
    this.getAllProducts();
  }

  constructor(private httpservice: HttpClientService) { }
}
