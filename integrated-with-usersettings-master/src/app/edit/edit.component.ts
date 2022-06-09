import { Component, Input, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/User';
import { RoutingService } from '../routing.service';
import { UpdateProfileService } from '../update-profile.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  @Input()
  userobj:User;
  

  constructor(private updateService:UpdateProfileService,private router:Router,private routing:RoutingService) {
      this.updateService.fetchDatafromServer();
      this.userobj = new User();

    
         }

  ngOnInit(): void {
    //this.view()
  }
  /*view(){
    this.updateService.getUser();
  }*/
  

  
  updateUser(){
    this.updateService.updateUser(this.userobj).subscribe(
      res=>{
        console.log(res);
        this.userobj=new User();
      },
      err=>{console.log(err)}
    );
    this.router.navigate(['/navigate/setting'])
  }
}
