import { Component, OnInit } from '@angular/core';
import { HttpClientService } from 'src/app/services/http-client.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  constructor(private httpservice: HttpClientService) { }

  products = this.httpservice.products();


  ngOnInit(): void {


  }

}
