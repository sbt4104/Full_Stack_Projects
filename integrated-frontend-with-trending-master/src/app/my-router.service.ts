import { Injectable } from '@angular/core';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class MyRouteService {

  constructor(private routerobj : Router) 
     { }

 
 openDashboard()
 {
   this.routerobj.navigate(['navigate/dashboard']);
   
 }

 openNavigate()
 {
   this.routerobj.navigate(['navigate']);
   
 }
//  openWatchlist()
//  {
//    this.routerobj.navigate(['watchlist']);
//  }

 openSetting()
 {
   this.routerobj.navigate(['navigate/setting']);
 }
 openbank()
 {
   this.routerobj.navigate(['navigate/bankdashboard']);
 }


}
