import { Component, Input } from '@angular/core';
import { HttpClientService } from '../services/http-client.service';
import { Product } from '../product/product';
import {DomSanitizer} from '@angular/platform-browser';
import {MatIconRegistry} from '@angular/material/icon';


const ADD_ICON = '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><line x1="12" y1="8" x2="12" y2="16" fill="#fff" stroke="#fff" stroke-miterlimit="10"/><line x1="16" y1="12" x2="8" y2="12" fill="#fff" stroke="#fff" stroke-miterlimit="10"/><circle cx="12" cy="12" r="10" fill="none" stroke="#fff"/></svg>'

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

  openCreateProductDialog() {

  }

  

  constructor(private httpservice: HttpClientService, private iconRegistry: MatIconRegistry, private sanitizer: DomSanitizer) { 
    iconRegistry.addSvgIconLiteral('add-icon', sanitizer.bypassSecurityTrustHtml(ADD_ICON));
  }
}
