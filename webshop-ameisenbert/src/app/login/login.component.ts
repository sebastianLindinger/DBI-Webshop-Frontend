import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { FormControl, NgForm, Validators, FormBuilder } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router, private formBuilder: FormBuilder) { }

  textFormControl = new FormControl('', [
    Validators.required,
  ]);

  passwordFormControl = new FormControl('', [
    Validators.required,
  ]);

  username: string = '';
  password: string = '';
  message: string = '';
  userIsLoggedIn: boolean = localStorage.getItem('userID') != '-1';

  ngOnInit() { }

  onSubmit() {
    console.log('button Submit clicked')
    console.log(this.password)
    console.log();
    this.authService.login({userName: this.username, password: this.password}).subscribe(res => {
      var userID = res as string;
      localStorage.setItem('userID', userID);
      if (userID == '-1') {
              this.message = 'Login failed!';
      }
      else {
        this.userIsLoggedIn = true;
        this.message = 'Login successful!';
        this.router.navigateByUrl('/home')
      }
      console.log(this.message)
    });
  }

  logout() {
    this.userIsLoggedIn = false;
    localStorage.setItem('userID', '-1');
    this.message = 'Logout successful!';
  }
}
