import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

 
  constructor(private httpcli : HttpClient) {

  }

getTokenfromserver(data:any):Observable<any>
{
return this.httpcli.post('http://localhost:9097/natwest/login',data);
}
adduser(data:any):Observable<any>
{
return this.httpcli.post('http://localhost:9097/natwest/addUser',data);
}


storeToken(tok:any)
{
 sessionStorage.setItem("mytoken",tok);
}


getToken():any
{
 return sessionStorage.getItem("mytoken");
}

}
