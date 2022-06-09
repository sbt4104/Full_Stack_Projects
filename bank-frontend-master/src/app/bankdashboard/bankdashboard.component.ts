import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AddbankComponent } from '../addbank/addbank.component';
import { BankService } from '../bank.service';

@Component({
  selector: 'app-bankdashboard',
  templateUrl: './bankdashboard.component.html',
  styleUrls: ['./bankdashboard.component.css']
})
export class BankdashboardComponent implements OnInit {

  constructor(private dialog:MatDialog,private bankservice:BankService) 
  {
    this.bankservice.storeUserid("shubham");
    let data={"userid":bankservice.getid()};
    this.bankservice.addUser(data).subscribe();
  }

  ngOnInit(): void 
  {
  }
  addbank()
  {
    const dialconfig=new MatDialogConfig();
    dialconfig.width="70%";
    this.dialog.open(AddbankComponent,dialconfig);
  }
}
