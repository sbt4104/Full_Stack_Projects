import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/User';
import { RoutingService } from '../routing.service';
import { UpdateProfileService } from '../update-profile.service';

@Component({
  selector: 'app-user-setting',
  templateUrl: './user-setting.component.html',
  styleUrls: ['./user-setting.component.css']
})
export class UserSettingComponent implements OnInit {
  user:any;
  userlist:Array<User>=[];
  uid:String;
  
  
  
  
  
  //uId:String=sessionStorage.getItem('userId');
  constructor(private router: Router,private updProfile:UpdateProfileService,private routing: RoutingService) { 
    this.updProfile.fetchDatafromServer();
    //this.user.firstName=routing.getUsername(); 
    this.uid=routing.getid();
  
  }

  ngOnInit(): void {
    /*this.updProfile.viewUser().subscribe((u: User)=> this.user={
      firstName:u.firstName,
      lastName:u.lastName,
      password:u.password,
      mobileNumber:u.mobileNumber,
    });*/
    //this.getUserlist();
    //console.log(this.userlist);
    //console.log(this.user);
    this.user=this.updProfile.getUser();
    //console.log(this.user.firstName,this.user.lastName,this.user.mobileNumber,this.user.password);

  }
/*
  getUserlist(){
    this.updProfile.getUsers().subscribe(userl =>{this.userlist=userl;});
  }
  
  getCurrUser(){
    this.getUserlist()
  }*/

  onSubmit(){
    this.router.navigate(['/edit'])
  }

  }
