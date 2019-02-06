import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isLoggedIn = false;
  user:any;
  role:String;
  authenticationData:any;
  userData:any;
  token:any;
  isAdmin = false;

  constructor(private router: Router) {
  }

  login() {
    sessionStorage.clear();
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
getRole() {
  return this.role;
}

setRole(role: string) {
  this.role = role;
}


setToken(token) {
  this.token = token;
}

getToken() {
  return this.token;
}


 }

