import { Component, OnInit } from '@angular/core';
import { FormControl, NgForm, Validators } from '@angular/forms';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {
  textFormControl = new FormControl('', [
    Validators.required,
  ]);

  priceFormControl = new FormControl('', [
    Validators.required,
  ]);

  weightFormControl = new FormControl('', [
    Validators.required,
  ]);

  ngOnInit(): void {
  }

  createProduct(payload: Object) {
    console.log(Object);
    console.log('Data is created - Result - Du muast de methode in onSubmit mochn so wie bei login', );
  }

  onSubmit(f: NgForm) {
    console.log('create product clicked');
    this.apiService.post("/products", {})
  }

  constructor(private apiService: ApiService) { }

}
