import { Component, OnInit } from '@angular/core';

import {MatTableDataSource} from '@angular/material/table';
import { MyRouteService } from '../my-router.service';

import { Stocks } from '../stocks';
import { WatchlistService } from '../watchlist.service';

import { AvatarComponent } from '../avatar/avatar.component';


export interface stocks {
  name: string;
  position: number;
  esg: string;
  eps: number;
  roe: number;
  divi: string;
}

const ELEMENT_DATA: stocks[] = [
  {position: 1, name: 'Nvidia', esg: 'AAA', eps: 99,roe:33,divi:"0.01%"},
  {position: 2, name: 'Salesforce.com',esg: 'AAA', eps: 95,roe:10,divi:"NA" },
  {position: 3, name: 'West Pharmaceutical Services',esg: 'AA', eps: 97,roe:17,divi:"0.2" },
  {position: 4, name: 'Vertex Pharmaceuticals',esg: 'AA', eps: 99,roe:26,divi:"NA" },
  {position: 5, name: 'Adobe',esg: 'AA', eps: 99,roe:39,divi:"NA" },
  {position: 6, name: 'Cadence Design Systems',esg: 'AA', eps: 95,roe:36,divi:"NA" },
  {position: 7, name: 'iRobot',esg: 'AA', eps: 87,roe:18,divi:"NA" },
  {position: 8, name: 'Comfort Systems USA', esg: 'AA', eps: 97,roe:21,divi:".7%"},
  {position: 9, name: 'Lam Research', esg: 'AA', eps: 95,roe:48,divi:"1.4%"},
  {position: 10, name: 'Intuit',  esg: 'AA', eps: 94,roe:47,divi:".7%"},
  {position: 11, name: 'Boise Cascade',  esg: 'AA', eps: 93,roe:47,divi:"NA"},
  {position: 12, name: 'Agilent Technologies',  esg: 'AA', eps: 94,roe:47,divi:".3%"},
  {position: 13, name: 'BWX Technologies',  esg: 'AA', eps: 85,roe:41,divi:".1%"},
  {position: 14, name: 'Mettler Toledo International',  esg: 'AA', eps: 88,roe:46,divi:".2%"},
  {position: 15, name: 'Prologis',  esg: 'AA', eps: 98,roe:45,divi:"NA"},
  {position: 16, name: 'Edwards Lifesciences',  esg: 'AA', eps: 91,roe:42,divi:".7%"},
  {position: 17, name: 'Home Depot',  esg: 'AA', eps: 94,roe:26,divi:".7%"},
  {position: 18, name: 'Quanta Services',  esg: 'AA', eps: 92,roe:15,divi:".7%"},
  {position: 19, name: 'Trimble',  esg: 'AA', eps: 87,roe:31,divi:"NA"},
  {position: 20, name: 'Herman Miller',  esg: 'AA', eps: 88,roe:44,divi:"1.4%"},
  {position: 21, name: 'Clorox',  esg: 'AA', eps: 85,roe:26,divi:"2.1%"},
  {position: 22, name: 'BioTelemetry',  esg: 'AA', eps: 86,roe:21,divi:".4%"},
  {position: 23, name: 'Tivity Health',  esg: 'AA', eps: 90,roe:37,divi:"NA"},
  {position: 24, name: 'Kansas City Southern',  esg: 'AA', eps: 89,roe:31,divi:".5%"},

];


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  

  clicked = false;

  newobj:Stocks;

  constructor(private route:MyRouteService ,private watchlistservice:WatchlistService) { 
    this.newobj = new Stocks();
  }

  ngOnInit(): void {
  }
  displayedColumns: string[] = ['position', 'name', 'esg', 'eps','roe','divi'];
  dataSource = new MatTableDataSource(ELEMENT_DATA);

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  addmethod1(pos:any)
  {
    this.actionMethod(pos);
    window.location.reload();
  }
  actionMethod(pos:any)
  {
    
    console.log(pos);
    const temp = ELEMENT_DATA[pos-1];
    this.newobj.name = temp.name;
    const user = "raghav@gmail.com";
    this.watchlistservice.storeUserid(user);
    console.log(user);

    let data={"stockname":this.newobj.name};
    this.watchlistservice.addStock(this.watchlistservice.getid(),data).subscribe();
    
  }

}
