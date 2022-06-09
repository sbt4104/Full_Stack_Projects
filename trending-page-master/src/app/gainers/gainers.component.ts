import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-gainers',
  templateUrl: './gainers.component.html',
  styleUrls: ['./gainers.component.css']
})
export class GainersComponent implements OnInit {
  constructor(private http:HttpClient){}
  gainer:any;
  loser:any;
  readonly url= "http://localhost:3000/nse/get_gainers";
  readonly url2= "http://localhost:3000/nse/get_losers";
  ngOnInit(): void {
    this.http.get(this.url).subscribe((res)=>{
      this.gainer=res;

      // console.log(parseFloat(this.gainer['data'][0].openPrice));
      // console.log(this.gainer['data'][0].highPrice);
      // console.log((parseFloat(this.gainer['data'][0].highPrice)-parseFloat(this.gainer['data'][0].openPrice)));
    })
    this.http.get(this.url2).subscribe((res)=>{
      this.loser=res;
    })
  }

}
