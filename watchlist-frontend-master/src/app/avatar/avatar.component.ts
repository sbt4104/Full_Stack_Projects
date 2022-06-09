import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-avatar',
  templateUrl: './avatar.component.html',
  styleUrls: ['./avatar.component.css']
})
export class AvatarComponent implements OnInit {

   currentUser = "Raghabendra Sharma";
   UserInitial = "R";

  constructor() { }

  fun()
  {

    alert(this.currentUser);
  }
  ngOnInit(): void {
  }

  
}
