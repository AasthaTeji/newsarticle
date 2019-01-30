import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders(
    {
      'Content-Type': 'application/json',
    }
  )
};
@Injectable({
  providedIn: 'root'
})

export class NewsService {

  markArticleUrl : string = "/newsarticle/save"
  constructor(private http: HttpClient) { }

  markFavourite(articleData): Observable<any> {
    return this.http.post(this.markArticleUrl, articleData, httpOptions);
  }
}
