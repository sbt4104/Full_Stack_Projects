import { Component, OnInit } from '@angular/core';
import { User } from 'src/User';
import { UpdateProfileService } from '../update-profile.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  userobj: User;
  uId:String=sessionStorage.getItem('userId');
  fN: String;
  lN: String;
  password: Number;
  mobileNo:String;

  constructor(private updateService:UpdateProfileService) {
      //this.updateService.fetchDatafromServer();
   }

  ngOnInit(): void {
    this.viewUser();
    this.fN=this.userobj.firstName;
    this.lN=this.userobj.lastName;
    this.password=this.userobj.password;
    this.mobileNo=this.userobj.mobileNumber;
  }

  viewUser(){
    this.updateService.getUser(this.uId).subscribe(res => 
      {this.userobj=res;}
      )
    }
}
