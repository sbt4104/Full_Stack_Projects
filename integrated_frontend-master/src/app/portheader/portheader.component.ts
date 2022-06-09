import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AddportfolioComponent } from '../addportfolio/addportfolio.component';
// import { Portfolio } from '../portfolio';
import { PortfolioService } from '../portfolio.service';

@Component({
  selector: 'app-portheader',
  templateUrl: './portheader.component.html',
  styleUrls: ['./portheader.component.css']
})
export class PortheaderComponent implements OnInit {
  errMessage: string="";
  isView = true;


  constructor(private portservice:PortfolioService,private dialog:MatDialog) 
  {
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
