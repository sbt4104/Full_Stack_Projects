import { Inject } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogConfig, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { PortfolioService } from '../portfolio.service';
import { RoutingService } from '../routing.service';

interface Food {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-watchlisttrade',
  templateUrl: './watchlisttrade.component.html',
  styleUrls: ['./watchlisttrade.component.css']
})
export class WatchlisttradeComponent implements OnInit {

  errMessage: string="";
  stockname:string;
  name = new FormControl('',Validators.required);
  quantity= new FormControl('',Validators.required);

  portfolioName :string = "";
  stockquantity:number =0;
  tradetype: string = "";
  stockprice: number = 0;

  form: FormGroup;
 


  foods: Food[] = [
    {value: 'Healthcare', viewValue: 'Healthcare'},
    {value: 'Automobile', viewValue: 'Automobile'},
    {value: 'Software', viewValue: 'Software'},
    {value: 'Solar Energy', viewValue: 'Solar Energy'},
    {value: 'Semiconductor', viewValue: 'Semiconductor'}
  ];
  foodControl = new FormControl(this.foods[2].value);


  constructor(@Inject(MAT_DIALOG_DATA) data:any,private dialog:MatDialog,private routeobj: RoutingService, private portservice: PortfolioService) { 
    this.stockname = data;
    this.form = new FormGroup({
      food: this.foodControl
    });
  }

  ngOnInit(): void {
  }
  validateName()
  {
    let ans="";
    if(this.name.touched && this.name.dirty)
    {
      if(this.name.hasError('required'))
        ans="Name can not be null";
    }
    return ans;
  }
  validatedQuantity()
  {
    let ans="";
    if(this.quantity.touched && this.quantity.dirty)
    {
      if(this.quantity.hasError('required'))
        ans="quantity can not be null";
    }
    return ans;
  }

  save_trade() {
    let data_stocks=
    {
      "stock":this.stockname,
      "quantity":this.stockquantity,
      "buySell":this.tradetype,
      "price": this.stockprice
    }
    this.portservice.tradeStocks(this.routeobj.getid(),this.portfolioName,data_stocks).subscribe(
      res => {

      },
      err => {
        
      }
    );
  }

  save_portfolio() {
    let data_portfolio =
    {
      "name": this.portfolioName,
      "description": "This is "+this.portfolioName+" portfolio"
    }
   this.portservice.addPortfoilio(this.routeobj.getid(), data_portfolio).subscribe(
      res => {
        this.save_trade();
      },
      err => {
        this.save_trade();
      }
    );

  }

  save_user() {
    let data_user = {"userid": this.routeobj.getid()};
    this.portservice.addUser(data_user).subscribe(
      res => {
        this.save_portfolio();
      },
      err => {
        this.save_portfolio();
      }
    );
  }

  save()
  {
  this.portfolioName=this.foodControl.value;

    if (this.portfolioName.length==0) 
    {
      this.errMessage = "Please enter portfolio";
      return;
    }
    else if(this.stockquantity==0|| this.stockquantity==null)
    {
      this.errMessage = "I guess you forgot to enter the quantity";
      return;
    }
  

    this.save_user();  
      
    const dialconfig2=new MatDialogConfig();

    // dialconfig2.width="60%";
    // dialconfig2.data=this.portname;
    // this.dialog.open(ListStocksComponent,dialconfig2);
    this.dialog.closeAll();
    // window.location.reload();
  }
}
