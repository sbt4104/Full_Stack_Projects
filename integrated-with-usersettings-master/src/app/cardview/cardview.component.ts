import { Input } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AddportfolioComponent } from '../addportfolio/addportfolio.component';
import { ListStocksComponent } from '../list-stocks/list-stocks.component';
import { PortfolioService } from '../portfolio.service';
import { MyRouteService } from '../my-router.service';
import { TradeComponent } from '../trade/trade.component';
import { RoutingService } from '../routing.service';

@Component({
  selector: 'app-cardview',
  templateUrl: './cardview.component.html',
  styleUrls: ['./cardview.component.css']
})
export class CardviewComponent implements OnInit 
{
  @Input()
  myportfolio: any;

  constructor(private portservice:PortfolioService,private route :MyRouteService,
    private dialog: MatDialog, private routeobj: RoutingService) { }

  ngOnInit(): void 
  {

  }
  delete()
  {
    this.portservice.deletePortfolio(this.routeobj.getid(), this.myportfolio.name).subscribe();
    // this.route.opendashboard();
    window.location.reload();
  }
  open()
  {
    const dialconfig=new MatDialogConfig();
    dialconfig.width="60%";
    dialconfig.data=this.myportfolio.name;
    dialconfig.closeOnNavigation=true;
    this.dialog.open(TradeComponent,dialconfig);
  }

  list_stocks()
  {
    const dialconfig2=new MatDialogConfig();
    dialconfig2.width="60%";
    dialconfig2.data=this.myportfolio.name;
    dialconfig2.closeOnNavigation=true;
    this.dialog.open(ListStocksComponent,dialconfig2);
  }
}
