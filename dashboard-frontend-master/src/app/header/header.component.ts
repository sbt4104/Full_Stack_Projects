import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AddportfolioComponent } from '../addportfolio/addportfolio.component';
import { Portfolio } from '../portfolio';
import { PortfolioService } from '../portfolio.service';
import { RouterserviceService } from '../routerservice.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  errMessage: string="";
  isView = true;


  constructor(private route:RouterserviceService,private portservice:PortfolioService,private dialog:MatDialog) 
  {
    //adding the user
    this.portservice.storeUserid("deepak");
    let data={"userid":portservice.getid()};
    this.portservice.addUser(data).subscribe();
  }
  ngOnInit(): void 
  {
   
  }
  addportfolio()
  {
    const dialconfig=new MatDialogConfig();
    dialconfig.width="70%";
    this.dialog.open(AddportfolioComponent,dialconfig);
  }
  close()
  {
    this.dialog.closeAll();
  }
  
}
