import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SqlauthService {

  constructor(private httpcli : HttpClient) {

  }
/*
getTokenfromserver(data:any):Observable<any>
{
return this.httpcli.post('http://localhost:9095/api/auth/login',data);
}



storeToken(tok:any)
{
 sessionStorage.setItem("mytoken",tok);
}


getToken():any
{
 return sessionStorage.getItem("mytoken");
}


*/

}
