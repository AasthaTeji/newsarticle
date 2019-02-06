import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { NewsService } from '../news.service';

@Component({
  selector: 'app-findanalyst',
  templateUrl: './findanalyst.component.html',
  styleUrls: ['./findanalyst.component.css']
})
export class FindanalystComponent implements OnInit {

  userName:any;
  name:any;
  analyst:any;
  analystStatus:boolean=false;
  error:any;
  constructor(private authService:AuthService, private newsService :NewsService) { }

  ngOnInit() {
  }
  searchAnalyst(name){
    console.log(name);
    
    this.newsService.searchAnalyst(name).subscribe(data=>{
      this.analystStatus =true;
      this.analyst= data;
      console.log(data);    
    },
    error=>{
      this.error = error;
      console.log(this.error);
    });
  }

}
