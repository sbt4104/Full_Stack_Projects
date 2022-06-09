import { Inject } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { PortfolioService } from '../portfolio.service';

@Component({
  selector: 'app-list-stocks',
  templateUrl: './list-stocks.component.html',
  styleUrls: ['./list-stocks.component.css']
})
export class ListStocksComponent implements OnInit 
{
  errMessage:string="";
  stockslist:any;
  porfolio_name:string;
  constructor(@Inject(MAT_DIALOG_DATA) data:any,private portservice:PortfolioService) 
  {
    this.porfolio_name=data;
  }
  ngOnInit(): void 
  {
    this.fetchstocks();
  }
  
  fetchstocks()
  {
      this.portservice.getStocks(this.portservice.getid(),this.porfolio_name).subscribe(response => 
        {
        if (response) 
        {
            this.stockslist=response;
        }
      else {
        this.errMessage = 'We are unable to retreive the stockslist.';
      }
    }, error => {
      this.errMessage = 'Http failure response ,404 Not Found';
    });
  }


}
