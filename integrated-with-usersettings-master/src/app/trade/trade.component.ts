import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { PortfolioService } from '../portfolio.service';
import { Portstocks } from '../port-stocks';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Inject } from '@angular/core';
import { ListStocksComponent } from '../list-stocks/list-stocks.component';

interface Food {
  value: string;
  viewValue: string;
}


@Component({
  selector: 'app-trade',
  templateUrl: './trade.component.html',
  styleUrls: ['./trade.component.css']
})
export class TradeComponent implements OnInit {

  errMessage: string="";
  stock_obj=new Portstocks();
  name = new FormControl('',Validators.required);
  quantity= new FormControl('',Validators.required);

  portname:string="";
  form: FormGroup;
  foods: Food[] = [
    {value: 'Salesforce', viewValue: 'Salesforce'},
    {value: 'Nvidia', viewValue: 'Nvidia'},
    {value: 'Intuit', viewValue: 'Intuit'},
    {value: 'Tivity Health', viewValue: 'Tivity Health'},
    {value: 'Prologis', viewValue: 'Prologis'},
    {value: 'BWX Technologies', viewValue: 'BWX Technologies'},
    {value: 'Quanta Services', viewValue: 'Quanta Services'},
    {value: 'Boise Cascade', viewValue: 'Boise Cascade'},
    {value: 'Herman Miller', viewValue: 'Herman Miller'},
    {value: 'Adobe', viewValue: 'Adobe'}
  ];
 
  foodControl = new FormControl(this.foods[0].value);

  constructor(private dialog:MatDialog,private portservice:PortfolioService,
    @Inject(MAT_DIALOG_DATA) data:any) 
    {
      this.portname=data;
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
  save()
  {
    this.stock_obj.name=this.foodControl.value;
    if (this.stock_obj.name.length==0) 
    {
      this.errMessage = "Please enter the name";
      return;
    }
    else if(this.stock_obj.quantity==0|| this.stock_obj.quantity==null)
    {
      this.errMessage = "I guess you forgot to enter the quantity";
      return;
    }
  
      let data=
      {
        "stock":this.stock_obj.name,
        "quantity":this.stock_obj.quantity,
        "buySell":this.stock_obj.mode,
        "price":this.stock_obj.price
      }

      this.portservice.tradeStocks(this.portservice.getid(),this.portname,data).subscribe();
      // const dialconfig2=new MatDialogConfig();
      // dialconfig2.width="60%";
      // dialconfig2.data=this.portname;
      // this.dialog.open(ListStocksComponent,dialconfig2);
      this.dialog.closeAll();
      window.location.reload();
  }
}
