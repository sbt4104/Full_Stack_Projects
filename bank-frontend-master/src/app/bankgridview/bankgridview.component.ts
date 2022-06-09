import { Component, OnInit } from '@angular/core';
import { BankService } from '../bank.service';

@Component({
  selector: 'app-gridview',
  templateUrl: './bankgridview.component.html',
  styleUrls: ['./bankgridview.component.css']
})
export class BankgridviewComponent implements OnInit 
{
  banklist:any;
  errMessage:String = "";
  constructor(private bank_service :BankService)
  {
    this.bank_service.viewBanks(this.bank_service.getid());
  }

  ngOnInit(): void 
  { 
    this.fetchbanks();

  }


  fetchbanks()
  {
      this.bank_service.getbanks().subscribe(response => 
        {
        if (response) 
        {
            this.banklist=response;
        }
      else {
        this.errMessage = 'We are unable to retreive the Portfolios list.';
      }
    }, error => 
    {
      this.errMessage = 'Http failure response ,404 Not Found';
    });
  }

}
