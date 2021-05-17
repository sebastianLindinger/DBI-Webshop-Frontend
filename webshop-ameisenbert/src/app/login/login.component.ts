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

  ngOnInit() { }

  onSubmit(f: NgForm) {
    /*this.alertService.info('Checking User Info');
    this.progressBar.startLoading();
    const loginObserver = {
      next: x => {
        this.progressBar.setSuccess();
        console.log('User logged in');
        this.alertService.success('Logged In');
        this.progressBar.completeLoading();
      },
      error: err => {
        this.progressBar.setError();
        console.log(err);
        this.alertService.danger('Unable to Login');
        this.progressBar.completeLoading();
      }
    };
    this.authService.login(f.value).subscribe(loginObserver);
*/
    console.log('button Submit clicked')
    this.authService.login(f.value);
    
    console.log(localStorage.getItem('userID'));
  }

}
