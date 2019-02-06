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
export class SignupService{
    signupUrl: string = "/newsarticle/signup"
    fetchLanguageUrl: string = "/newsarticle/list"
    constructor(private http: HttpClient){}
    signup(json): Observable<any>{
        return this.http.post<any>(this.signupUrl, json, httpOptions);
    }
    fetchAllLanguages(): Observable<any>{
        return this.http.get<any>(this.fetchLanguageUrl);
    }
}