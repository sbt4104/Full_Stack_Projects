import { Component, OnInit } from '@angular/core';
import { PortfolioService } from '../portfolio.service';

@Component({
  selector: 'app-gridview',
  templateUrl: './gridview.component.html',
  styleUrls: ['./gridview.component.css']
})
export class GridviewComponent implements OnInit {
  portfoliolist:any;
  errMessage:String = "";

  constructor(private portservice :PortfolioService) 
  {
    this.portservice.viewPortfolios(this.portservice.getid());
  }

  ngOnInit(): void 
  {
    this.fetchportfolios();
  }

  fetchportfolios()
  {
      this.portservice.getPortfolios().subscribe(response => 
        {
        if (response) 
        {
            this.portfoliolist=response;
        }
      else {
        this.errMessage = 'We are unable to retreive the Portfolios list.';
      }
    }, error => {
      this.errMessage = 'Http failure response ,404 Not Found';
    });
  }

}
