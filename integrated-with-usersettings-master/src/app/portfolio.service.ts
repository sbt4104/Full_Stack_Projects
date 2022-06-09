import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Observable } from 'rxjs';
import { tap } from "rxjs/operators";
@Injectable({
  providedIn: 'root'
})
export class PortfolioService 
{
  portfoliolist:Array<any>;
  portfolioSubject: BehaviorSubject<Array<any>>;

  constructor(private httpcli:HttpClient) 
  {
    this.portfoliolist = [];
    this.portfolioSubject = new BehaviorSubject(this.portfoliolist); 
  }

 
  getPortfolios(): BehaviorSubject<any> 
  {
    return this.portfolioSubject;
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

  addUser(data:any):Observable<any>
  {
    console.log(data);
    return this.httpcli.post('http://localhost:9006/api/portfolio/adduser',data);
  }
  addPortfoilio(userid:string,data:any):Observable<any>
  {
    return this.httpcli.post("http://localhost:9006/api/portfolio/createportfolio/"+userid,data)
    .pipe (
      tap ( (portfolios:any) => 
      {
        this.portfoliolist.push(portfolios);
        this.portfolioSubject?.next(this.portfoliolist);
      }
      )
    );
  }

  viewPortfolios(userid:string)
  {
    return this.httpcli.get("http://localhost:9006/api/portfolio/viewallportfolios/"+userid).subscribe
    (
         (portfolios:any) => 
        {
          this.portfoliolist=portfolios;
          this.portfolioSubject?.next(this.portfoliolist);
        }
     )

  }

  deletePortfolio(userid:string,portfolioname:string)
  {
    return this.httpcli.delete("http://localhost:9006/api/portfolio/deleteportfolio/"+userid+"/"+portfolioname).
    pipe(
      tap( () =>
        {
          const ind = this.portfoliolist.findIndex(prd => prd.name = portfolioname);
          this.portfoliolist.splice(ind,1);
          this.portfolioSubject?.next(this.portfoliolist);
        }
      )
    );
   
  }

  getTrades(userid:string,portfolioname:string)
  {
    return this.httpcli.get("http://localhost:9006/api/portfolio/getTrades/${userid}/${portfolioname}");
  }

  getPortfolio(userid:string,portfolioname:string)
  {
    return this.httpcli.get("http://localhost:9006/api/portfolio/getportfolio/${userid}/${portfolioname}");
  }


  getStocks(userid:string,portfolioname:string)
  {
    return this.httpcli.get(`http://localhost:9006/api/portfolio/getStocks/${userid}/${portfolioname}`);
  }

 

  tradeStocks(userid:string,portfolioname:string,data:any)
  {
    return this.httpcli.post("http://localhost:9006/api/portfolio/tradeStocks/"+userid+"/"+
    portfolioname,data);

  }
  deleteUser(userid:string)
  {
    return this.httpcli.delete("http://localhost:9006/api/portfolio/deleteUser/${userid}");
  }
  viewallusers()
  {
    return this.httpcli.get("http://localhost:9006/api/portfolio/viewallusers");
  }



}
