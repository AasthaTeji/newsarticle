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

  markArticleUrl : string = "/newsarticle/rest/save"
  listArticleUrl : string ="/newsarticle/rest/show/"
  deleteFavArticleUrl :string ="/newsarticle/rest/delete"
  searchAnalystUrl :string="/newsarticle/rest/search/"
  constructor(private http: HttpClient) { }

  markFavourite(articleData): Observable<any> {
    return this.http.post(this.markArticleUrl, articleData, httpOptions);
  }

  listFavArticle(email): Observable<any> {
    return this.http.get(this.listArticleUrl + email);
  }
  deleteFavarticle(article): Observable<any> {
    return this.http.post(this.deleteFavArticleUrl,article,httpOptions);
  }

  searchAnalyst(name): Observable<any> {
    return this.http.get(this.searchAnalystUrl + name);
  }
}
