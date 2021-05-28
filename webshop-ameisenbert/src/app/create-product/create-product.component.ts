import { Component, OnInit } from '@angular/core';
import { FormControl, NgForm, Validators } from '@angular/forms';

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

  onSubmit(f: NgForm) {
    console.log('create product clicked')
  }

  constructor() { }

}
