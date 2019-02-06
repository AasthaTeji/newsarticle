import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from './login.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  emailPattern = "^[a-zA-Z0-9._%+-]+@[A-Za-z0-9.-]+\.[a-zA-Z]{2,4}$";
  json:any;
  error:any;
  user:any;
  incorrectLogin:any;

  loginForm = new FormGroup({
    
    email: new FormControl(
      '', [Validators.required,
      Validators.pattern(this.emailPattern)],
    ),
    password: new FormControl(
      '',[Validators.required,
        Validators.minLength(6),
      Validators.maxLength(15)
      ]
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
          console.log(data.user.role);
         
          this.authService.setUser(data.user);
          this.authService.setRole(data.user.role.name);
          this.authService.setToken(data.token);
          this.authService.login();
          this.router.navigate(['/news']);
          this.incorrectLogin=false;
        } else {
          this.incorrectLogin = true;
        }
       
      },
      error=>{
        this.error = error;
        console.log(this.error);
      }
      
    );
  }

}
