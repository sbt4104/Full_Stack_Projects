import { Component, OnInit } from '@angular/core';
import { WatchlistService } from '../watchlist.service';

@Component({
  selector: 'app-avatar',
  templateUrl: './avatar.component.html',
  styleUrls: ['./avatar.component.css']
})
export class AvatarComponent implements OnInit {


   UserInitial = "l"
  
  constructor(private watchlist_service:WatchlistService) 
  {
    // this.watchlist_service.storeUserid("kuch bhi");
  }
  fun()
  {
    alert(this.watchlist_service.getid());
  }
  ngOnInit(): void 
  {
  }

  
}
