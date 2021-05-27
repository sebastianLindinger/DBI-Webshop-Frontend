import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';




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

  //matcher = new MyErrorStateMatcher();

  ngOnInit(): void {
  }

  onSubmit(f: NgForm) { }


  constructor() { }

}
