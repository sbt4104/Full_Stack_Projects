import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/User';
import { UpdateProfileService } from '../update-profile.service';

@Component({
  selector: 'app-user-setting',
  templateUrl: './user-setting.component.html',
  styleUrls: ['./user-setting.component.css']
})
export class UserSettingComponent implements OnInit {

  user:User;
  Name:String;
  uId:String=sessionStorage.getItem('userId');
  constructor(private router: Router,private updProfile:UpdateProfileService) { 
    //this.updProfile.fetchDatafromServer();

  }

  ngOnInit(): void {
    this.viewUser()
    this.Name=this.user.firstName+" "+this.user.lastName;
  }

  onSubmit(){
    this.router.navigate(['/edit'])
  }
  viewUser(){
    this.updProfile.getUser(this.uId).subscribe(res => 
      {this.user=res;}
      )
  }
}