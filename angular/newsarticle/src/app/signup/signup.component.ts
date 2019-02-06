import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { SignupService } from './signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
languages:any;
  status:any={
    signupStatus:false,
    emailExist:false,
  };
  error:any;
json :any;
  signupForm = new FormGroup({
    name: new FormControl(
      '',
    ),
    email: new FormControl(
      ''
    ),
    password: new FormControl(
      ''
     ),
     language:new FormControl(
       '',
     )
  })

  constructor(private router: Router, private signupService: SignupService) { }

  ngOnInit() {
    this.signupService.fetchAllLanguages().subscribe(data=>
    {
      this.languages =data;
    });
  }

  signup(){
    this.json=JSON.stringify({
      language:{
        id:this.signupForm.controls['language'].value,
        },
      name:this.signupForm.controls['name'].value,
      email:this.signupForm.controls['email'].value,
      password:this.signupForm.controls['password'].value,
      role:{
        id:2
      }

    })
    console.log(this.json)
    this.signupService.signup(this.json).subscribe(
      data => {
        console.log(data)
        this.status=data;
        console.log(data.signupStatus)
        this.signupForm.reset();
      },
      error=>{
        this.error = error;
        console.log(this.error);
      }
      
    );
  }

}
