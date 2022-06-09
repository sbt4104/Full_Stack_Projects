import { TemplateRef } from '@angular/core';
import { ViewChild } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { FormControl, NgForm, Validators } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Portfolio } from '../portfolio';
import { PortfolioService } from '../portfolio.service';
import { RouterserviceService } from '../routerservice.service';

@Component({
  selector: 'app-addportfolio',
  templateUrl: './addportfolio.component.html',
  styleUrls: ['./addportfolio.component.css']
})
export class AddportfolioComponent implements OnInit {
  
  newobj:Portfolio;
  errMessage: string="";
  portfolios:Array<Portfolio>=[];
  portfolio_obj:Portfolio=new Portfolio();
  name = new FormControl('',Validators.required);
  description = new FormControl('',Validators.required);


  constructor(private route:RouterserviceService ,private portservice:PortfolioService,private dialog:MatDialog) 
  {
    this.newobj=new Portfolio();
  }

  ngOnInit(): void 
  {
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
  validatedDescription()
  {
    let ans="";
    if(this.description.touched && this.description.dirty)
    {
      if(this.description.hasError('required'))
        ans="Description can not be null";
    }
    return ans;
  }
  save()
  {
    this.newobj.name=this.portfolio_obj.name;
    this.newobj.description=this.portfolio_obj.description;

    let data={"name":this.newobj.name,"description":this.newobj.description}

    if (this.newobj.name.length==0 || this.newobj.description.length==0) {
      this.errMessage = 'Name and Description both are required fields';
      return;
    }
  
    //sending portfolio name and description to backend
  this.portservice.addPortfoilio(this.portservice.getid(),data).subscribe();
  this.dialog.closeAll();
  this.route.opendashboard();
   
  }

}
