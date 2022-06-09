import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { pipe } from 'rxjs';
import { Observable } from 'rxjs';
import { BehaviorSubject } from 'rxjs';
import { tap } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class BankService 
{
  banklist:Array<any>;
  bankSubject: BehaviorSubject<Array<any>>;

  constructor(private httpcli:HttpClient) 
  {
    this.banklist = [];
    this.bankSubject = new BehaviorSubject(this.banklist); 
  }

  // storeUserid(id:string)
  // {
  // sessionStorage.setItem("userid",id);
  // }

  getid():any
  {
  return sessionStorage.getItem("userid");
  }

  getbanks(): BehaviorSubject<any> 
  {
    return this.bankSubject;
  }

  //end points

  addUser(data:any):Observable<any>
  {
    return this.httpcli.post('http://localhost:9007/api/bank/adduser',data);
  }

  addBank(userid:string,data:any):Observable<any>
  {
    return this.httpcli.post("http://localhost:9007/api/bank/addbank/"+userid,data)
    .pipe (
      tap ( (portfolios:any) => 
      {
        this.banklist.push(portfolios);
        this.bankSubject?.next(this.banklist);
      }
      )
    );
  }

  viewBanks(userid:string)
  {
    return this.httpcli.get("http://localhost:9007/api/bank/viewbanks/"+userid).subscribe
    (
         (banks:any) => 
        {
          this.banklist=banks;
          this.bankSubject?.next(this.banklist);
        }
     )
  }

  deleteBank(userid:string,account_number:string)
  {
    return this.httpcli.delete("http://localhost:9007/api/bank/deletebank/"+account_number+"/"+userid).
    pipe(
      tap( () =>
        {
          const ind = this.banklist.findIndex(prd => prd.account_number= account_number);
          this.banklist.splice(ind,1);
          this.bankSubject?.next(this.banklist);
        }
      )
    );
  }
  
  updateBank(userid:string,data:any)
  {
    return this.httpcli.put("http://localhost:9007/api/bank/updatebank/"+userid,data).
    pipe(
      tap( (bank) =>
        {
          const ind = this.banklist.findIndex(prd => prd.account_number= data.account_number);
          this.banklist.splice(ind,1);
          this.banklist.push(bank);
          this.bankSubject?.next(this.banklist);
        }
      )
    );
  }

  makePrimary(userid:string, account_number:string){
    return this.httpcli.put("http://localhost:9007/api/bank/makeprimary/"+account_number+"/"+userid, null);
  }
}