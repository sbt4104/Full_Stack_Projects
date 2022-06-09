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

 //endpoints
  storeUserid(id:string)
  {
  sessionStorage.setItem("userid",id);
  }
  
  getStocks(): BehaviorSubject<any> 
  {
    return this.WatchlistSubject;
  }


  getid():any
  {
  return sessionStorage.getItem("userid");
  }

  
  
  addStock(userid:string,data:any):Observable<any>
  {
    console.log("parameter :",userid);
    console.log(data);
    return this.httpcli.post("http://localhost:9008/api/stockapp/worklist/{"+userid+"}/addstock",data)
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
    
    return this.httpcli.get("http://localhost:9008/api/stockapp/worklist/{"+userid+"}")
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

  deletestock(userid:string,stockname:string)
  {
    //deepak used port 9008
  return this.httpcli.delete("http://localhost:9008/api/stockapp/worklist/{"+userid+"}/deletestock",{body:{"stockname":stockname}})
    .pipe(
      tap( () =>
        {
          const ind = this.stocklist.findIndex(stockname);
          console.log("Index is ",ind);
          this.stocklist.splice(ind,1);
          this.WatchlistSubject?.next(this.stocklist);
        }
      )
    );
  }
  
}
