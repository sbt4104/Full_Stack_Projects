import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Observable } from 'rxjs';
import { tap } from "rxjs/operators";
@Injectable({
  providedIn: 'root'
})
export class WatchlistService 
{
  stocklist:any;
  WatchlistSubject: BehaviorSubject<any>;

  constructor(private httpcli:HttpClient) 
  {
    this.stocklist = [];
    this.WatchlistSubject = new BehaviorSubject(this.stocklist); 
  }

 
  getStocks(): BehaviorSubject<any> 
  {
    return this.WatchlistSubject;
  }

  //endpoints
  storeUserid(id:string)
  {
  sessionStorage.setItem("userid",id);
  }

  getid():any
  {
  return sessionStorage.getItem("userid");
  }

  
  
  addStock(userid:string,data:any):Observable<any>
  {
    console.log("parameter :",userid);
    console.log(data);
    return this.httpcli.post("http://localhost:9010/api/stockapp/worklist/{ravi@gmail.com}/addstock",data)
    .pipe (
      tap ( (stocks:any) => 
      {
        this.stocklist.push(stocks);
        this.WatchlistSubject?.next(this.stocklist);
      }
      )
    );
  
  }

  getWatchlist(): BehaviorSubject<any>
  {
    return this.WatchlistSubject;
  }
  viewWatchlist(userid:string)
  {
    console.log("parameter :",userid);
    
    return this.httpcli.get("http://localhost:9010/api/stockapp/worklist/{ravi@gmail.com}")
    .pipe (
      tap ( (s:any) => 
      {
        console.log(s);
        this.stocklist = s;
        this.WatchlistSubject?.next(this.stocklist);
      }
      )
    );
    
  }

  
}
