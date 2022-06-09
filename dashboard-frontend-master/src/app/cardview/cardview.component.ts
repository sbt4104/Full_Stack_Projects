import { Input } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AddportfolioComponent } from '../addportfolio/addportfolio.component';
import { ListStocksComponent } from '../list-stocks/list-stocks.component';
import { PortfolioService } from '../portfolio.service';
import { RouterserviceService } from '../routerservice.service';
import { TradeComponent } from '../trade/trade.component';

@Component({
  selector: 'app-cardview',
  templateUrl: './cardview.component.html',
  styleUrls: ['./cardview.component.css']
})
export class CardviewComponent implements OnInit 
{
  @Input()
  myportfolio: any;

  constructor(private portservice:PortfolioService,private route :RouterserviceService,
    private dialog: MatDialog) { }

  ngOnInit(): void 
  {

  }
  delete()
  {
    this.portservice.deletePortfolio(this.portservice.getid(), this.myportfolio.name).subscribe();
    this.route.opendashboard();
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
