import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RouterserviceService } from './routerservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'DashboardApp';
  constructor(private router: Router) {}
  ngOnInit() {
    this.router.navigate(['']);
  }
  
}
