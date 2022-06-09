import { Input } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { BankService } from '../bank.service';
import { BankupdateComponent } from '../bankupdate/bankupdate.component';

@Component({
  selector: 'app-bankcardview',
  templateUrl: './bankcardview.component.html',
  styleUrls: ['./bankcardview.component.css']
})
export class BankcardviewComponent implements OnInit {
  @Input()
  mybanks: any;
  constructor(private bank_service:BankService,private dialog:MatDialog) { }

  ngOnInit(): void {
  }

  delete()
  {
 
      this.bank_service.deleteBank(this.bank_service.getid(), this.mybanks.account_number).subscribe();
      window.location.reload();
    
  }
  update()
  {
    const dialconfig=new MatDialogConfig();
    dialconfig.width="60%";
    dialconfig.data=this.mybanks.account_number;
    dialconfig.closeOnNavigation=true;
    this.dialog.open(BankupdateComponent,dialconfig);
  }
}
