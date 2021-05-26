import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { HttpClientService } from '../services/http-client.service';
import { Product } from '../product/product';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-products2',
  templateUrl: './products2.component.html',
  styleUrls: ['./products2.component.css']
})
export class Products2Component {
  /** Based on the screen size, switch from standard to one column per row */
  products: Product[] = [];
  showProducts: Observable<any[]> | undefined;

  getAllProducts() {
    this.httpservice
      .products()
      .subscribe((res) => {
        console.log(res);
        this.products = <Product[]>(<unknown>res);
        this.showProducts = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
          map(({ matches }) => {
            console.log(matches)
            var colspan = matches ? 3 : 1;
            return this.products.map(obj => ({ ...obj, cols: colspan, rows: 1 }));
        }));
      });
  }

  ngOnInit(): void {
    this.getAllProducts();
  }

  constructor(private breakpointObserver: BreakpointObserver, private httpservice: HttpClientService) { }
}
