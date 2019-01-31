import { Component, OnInit } from '@angular/core';
import { NewsService } from '../news.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {
  userData:any;
  articlesResponse=[];
  favoriteArticleStatus=[];
error:any;
json:any;
mode:any={
  newsArticle :false,
  searchArticle :false
}
searchedWord:any;
languageCode:any;
  constructor(private newsService :NewsService,private authService :AuthService) { }

 
  ngOnInit() {

    this.mode.newsArticle=true;

this.userData=this.authService.getUser();

    const NewsAPI = require('newsapi');
    const newsapi = new NewsAPI('93f5f428aff044fa85ff16e9e77eb635');
    console.log(this.userData.language.code)
    newsapi.v2.everything({
     q: 'india', 
      sources: 'bbc-news,the-verge',
     /*  domains: 'bbc.co.uk, techcrunch.com',  */
     
      language: this.userData.language.code,
      sortBy: 'relevancy',
      page: 2
    }).then(response => {
      console.log(response);
     this.articlesResponse=response.articles;
    
    });
  }

  markFavourite(article){
    article['email']=this.userData.email;
    console.log("mark article favourite");
    this.newsService.markFavourite(article).subscribe(
      data => {
       console.log(article)
       alert("Article Marked Favourite")
      },
      error=>{
        this.error = error;
        console.log(this.error);
      });

  }

  searchArticle(word){

    this.searchedWord=word;
    const NewsAPI = require('newsapi');
const newsapi = new NewsAPI('93f5f428aff044fa85ff16e9e77eb635');
    newsapi.v2.everything({
     q: this.searchedWord, 
      sources: 'bbc-news,the-verge',
     /*  domains: 'bbc.co.uk, techcrunch.com',  */
     
      language: 'en',
      sortBy: 'relevancy',
      page: 2
    }).then(response => {
      console.log(response);
     this.articlesResponse=response.articles;
    
    });
  }
  
}
