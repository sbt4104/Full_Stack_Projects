import { Component, OnInit } from '@angular/core';
import { WatchlistService } from '../watchlist.service';

@Component({
  selector: 'app-mylist',
  templateUrl: './mylist.component.html',
  styleUrls: ['./mylist.component.css']
})
export class MylistComponent implements OnInit {

  watchlist:any;
  errMessage:String = "";

  constructor(private watchservice: WatchlistService) {

    this.watchservice.viewWatchlist(this.watchservice.getid()).subscribe(
      data => {
        this.watchlist = data;
      }
    );
    
   }

  ngOnInit(): void {

    this.fetchlist();
    
  }

  fetchlist()
  {
    this.watchservice.getWatchlist().subscribe(
      response =>
      {
        if (response)
        {
          console.log(response);
          this.watchlist = response;
        }
        else
        this.errMessage = "Unable to retrieve the portfolio list";
      },
    error => {
      this.errMessage = "Http failure, 404 Not found";
    });
    
  }
}
