import { Component, OnInit } from '@angular/core';
import { WatchlistService } from '../watchlist.service';

@Component({
  selector: 'app-avatar',
  templateUrl: './avatar.component.html',
  styleUrls: ['./avatar.component.css']
})
export class AvatarComponent implements OnInit {


   UserInitial:string;
  
  constructor(private watchlist_service:WatchlistService) 
  {
    this.UserInitial=this.watchlist_service.getid()[0];
    this.UserInitial=this.UserInitial.toUpperCase();
  }
  fun()
  {
    alert(this.watchlist_service.getid());
  }
  ngOnInit(): void 
  {
  }

  
}
