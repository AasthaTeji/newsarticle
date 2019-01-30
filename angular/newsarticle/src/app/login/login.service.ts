import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient, HttpHeaders } from "@angular/common/http";

const httpOptions ={
    headers: new HttpHeaders({
        'Content-Type': 'application/json'
    })
};
@Injectable({
    providedIn: 'root'
})
export class LoginService{
    url: string = "/newsarticle/login"
    constructor(private http: HttpClient){}
    login(json): Observable<any>{
        return this.http.post<any>(this.url, json, httpOptions);
    }
}