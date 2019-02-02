import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isLoggedIn = false;
  user:any;
  constructor(private router: Router) {
  }
  login() {
    this.isLoggedIn = true;
  }
  logout() {
    this.isLoggedIn = false;
    this.router.navigate(['']);
  }

setUser(user){
  this.user=user;
}

getUser(){
  return this.user;
}

  }

