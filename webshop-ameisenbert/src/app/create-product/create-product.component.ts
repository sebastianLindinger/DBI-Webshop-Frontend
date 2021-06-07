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

  name: string = '';
  weight: number = 0;
  price: number = 0;
  image: string = '';

  ngOnInit(): void {
  }

  onSubmit(f: NgForm) {
    console.log('create product clicked');
    console.log(this.name+' '+this.weight+' '+this.price+' '+this.image);
    this.apiService.post("products", {price: this.price, weight: this.weight, name:this.name, image:this.image}).subscribe(data => {
      console.log(data)
    });
  }

  constructor(private apiService: ApiService) { }

}
