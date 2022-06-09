import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { MyRouteService } from './my-router.service';

@Injectable({
  providedIn: 'root'
})
export class AppguardGuard implements CanActivate 
{
  constructor(private route:MyRouteService)
  {

  }
  token:string="";
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree 
    {
      if(sessionStorage.getItem("mytoken")!="")
      {
        return true;
      }
      this.route.openhome();
      return false;
  }
  
}
