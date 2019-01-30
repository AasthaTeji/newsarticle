import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '../../../node_modules/@angular/router';
import { LoginService } from './login.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  json:any;
  error:any;
  user:any;
  loginForm = new FormGroup({
    
    email: new FormControl(
      ''
    ),
    password: new FormControl(
      ''
     ),
     
  })
  constructor(private router: Router, private loginService: LoginService , private authService:AuthService) { }

  ngOnInit() {
  }
  login(){
    this.json=this.loginForm.value;
    this.loginService.login(this.json).subscribe(
      data => {
        console.log(data)
        if (data.authentication) {
          this.authService.login();
          this.authService.setUser(data.user);
          this.router.navigate(['/news']);
        } else {
          return false;
        }
       
      },
      error=>{
        this.error = error;
        console.log(this.error);
      }
      
    );
  }

}
