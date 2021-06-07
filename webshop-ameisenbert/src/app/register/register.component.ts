import { Component, OnInit } from '@angular/core';
import { FormControl, NgForm, Validators, FormBuilder } from '@angular/forms';
import { HttpClientService } from '../services/http-client.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  constructor(private httpservice: HttpClientService) { }

  textFormControl = new FormControl('', [
    Validators.required,
  ]);

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email
  ]);

  passwordFormControl = new FormControl('', [
    Validators.required,
    Validators.minLength(6)
  ]);

  username: string = '';
  password: string = '';
  email: string = '';

  onSubmit() {
    console.log('Register clicked')

    var model = {
      userName: this.username,
      password: this.password,
      email: this.email
    }

    this.httpservice.register(model).subscribe((data: any) => {
      console.log(data);
      if (data.hasOwnProperty('userID')) this.httpservice.createCartForUser(data['userID']).subscribe(data => console.log(data));
    });
  }
}