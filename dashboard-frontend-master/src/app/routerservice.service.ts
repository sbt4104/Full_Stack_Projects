import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouterserviceService 
{
  constructor(private router :Router) { }
  
  openPortfolio()
  {
    this.router.navigate(['add']);
  }
  opendashboard()
  {
    this.router.navigate(['']);
  }
  openTrade()
  {
    this.router.navigate(['trade']);
  }
  openGridview()
  {
    this.router.navigate(['header/gridview']);    
  }

}
