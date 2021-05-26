import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService: AuthService) { }

  message: string = '';
  userIsLoggedIn: boolean = localStorage.getItem('userID') != '-1';

  ngOnInit() { }

  onSubmit(f: NgForm) {
    console.log('button Submit clicked')
    this.authService.login(f.value).subscribe(res => {
      var userID = res as string;
      localStorage.setItem('userID', userID);
      if (userID == '-1') {
        this.message = 'Login failed!';
      }
      else {
        this.userIsLoggedIn = true;
        this.message = 'Login successful!';
      }
    });
  }

  logout() {
    this.userIsLoggedIn = false;
    localStorage.setItem('userID', '-1');
    this.message = 'Logout successful!';
  }
}
