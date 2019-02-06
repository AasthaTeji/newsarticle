import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { NewsService } from '../news.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {
  userData: any;
  articlesResponse = [];
  favoriteArticleStatus = [];
  error: any;
  json: any;
  mode: any = {
    newsArticle: false,
    searchArticle: false,
    favArticle :false
  }
  searchedWord: any;
  languageCode: any;
  favArticles: any = [];
  constructor(private newsService: NewsService, private authService: AuthService) { }


  ngOnInit() {

    this.mode.newsArticle = true;
    this.userData = this.authService.getUser();


    const NewsAPI = require('newsapi');
    const newsapi = new NewsAPI('93f5f428aff044fa85ff16e9e77eb635');
    console.log(this.userData.language.code)
    newsapi.v2.topHeadlines({
     
           /*  domains: 'bbc.co.uk, techcrunch.com',  */

      language: this.userData.language.code,
      
      sortBy: 'relevancy',
     
    }).then(response => {
      console.log(response);
      this.articlesResponse = response.articles;
      

    });
  }

  markFavourite(article) {
    article['email'] = this.userData.email;
    console.log("mark article favourite");
    this.newsService.markFavourite(article).subscribe(
      data => {
        console.log(article)
        alert("Article Marked Favourite")
      },
      error => {
        this.error = error;
        console.log(this.error);
      });

  }

  searchArticle(word) {

    this.searchedWord = word;
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
      this.mode.searchArticle = true;
      console.log(response);
      this.articlesResponse = response.articles;

    });
  }

  listFavArticles() {
    console.log(this.userData.email)
    this.newsService.listFavArticle(this.userData.email).subscribe(
      data=>{
        
        
          if (data != null) {
            this.mode.favArticle = true;
            this.mode.searchArticle = false;
            this.mode.newsArticle = false;
            this.favArticles = data.articles;
            console.log(this.favArticles)
            console.log("getting fav article")
        }
      },
      error => {
        this.error = error;
        console.log(this.error);
      });
    

  }

  deleteFavarticle(article) {
    article['email'] = this.userData.email;
    console.log("delete favourite article");
    this.newsService.deleteFavarticle(article).subscribe(
      data => {
        console.log(this.userData.email)
       
        this.favArticles=data.articles;
      },
      error => {
        this.error = error;
        console.log(this.error);
      });

  }


}
