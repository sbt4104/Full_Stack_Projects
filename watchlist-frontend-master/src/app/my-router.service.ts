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
   this.routerobj.navigate(['dashboard']);
   
 }

 openWatchlist()
 {
   this.routerobj.navigate(['watchlist']);
 }
 openSetting()
 {
   this.routerobj.navigate(['setting']);
 }


}
