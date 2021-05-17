import { Component, OnInit } from '@angular/core';
import { HttpClientService } from 'src/app/services/http-client.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  constructor(private httpservice: HttpClientService) { }

  ngOnInit(): void {


    var resp = this.httpservice.products();
    console.log(resp);
  }

}
