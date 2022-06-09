import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RoutingService {

  constructor(private route:Router) { }
  opensuccess(){
    this.route.navigate(['home/dashboard']);
  }
  openregister(){
    this.route.navigate(['home/user/register']);
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

}
