import { Input } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { MyRouteService } from '../my-router.service';
import { WatchlistService } from '../watchlist.service';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { TradeComponent } from '../trade/trade.component';
import { WatchlisttradeComponent } from '../watchlisttrade/watchlisttrade.component';
import { RoutingService } from '../routing.service';
@Component({
  selector: 'app-watchlistcardview',
  templateUrl: './watchlistcardview.component.html',
  styleUrls: ['./watchlistcardview.component.css']
})
export class WatchlistcardviewComponent implements OnInit {

  @Input()
  mywatchlist: any;

  constructor(private watchservice:WatchlistService,private route : MyRouteService,private dialog: MatDialog,private routeobj: RoutingService) { }

  ngOnInit(): void 
  {

  }
  delete()
  {
    this.watchservice.deletestock(this.routeobj.getid(), this.mywatchlist).subscribe();
    // this.route.openWatchlist();
    window.location.reload();
  }
  add_to_portfolio(x:any)
  {
    console.log();
    const dialconfig=new MatDialogConfig();
    dialconfig.width="60%";
    dialconfig.closeOnNavigation=true;
    dialconfig.autoFocus = true;
    dialconfig.disableClose = true;
    dialconfig.data = x;
    console.log(x);
    this.dialog.open(WatchlisttradeComponent,dialconfig);
  }
  

}



