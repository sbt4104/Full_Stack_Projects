import { Input } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { MyRouteService } from '../my-router.service';
import { WatchlistService } from '../watchlist.service';

@Component({
  selector: 'app-watchlistcardview',
  templateUrl: './watchlistcardview.component.html',
  styleUrls: ['./watchlistcardview.component.css']
})
export class WatchlistcardviewComponent implements OnInit {

  @Input()
  mywatchlist: any;

  constructor(private watchservice:WatchlistService,private route : MyRouteService) { }

  ngOnInit(): void 
  {

  }
  delete()
  {
    // this.portservice.deletePortfolio(this.portservice.getid(), this.myportfolio.name).subscribe();
    // this.route.opendashboard();
    // window.location.reload();
  }

  

}



