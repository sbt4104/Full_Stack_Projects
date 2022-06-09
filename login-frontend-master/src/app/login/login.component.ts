import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { AuthenticationService } from '../authentication.service';
import { RoutingService } from '../routing.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private routeobj : RoutingService,private authserv : AuthenticationService) { }

  ngOnInit(): void {
  }
  username = new FormControl('',Validators.email);
  password = new FormControl('',Validators.maxLength(4));

  validateName()
  {
    let ans="";
    if(this.username.touched && this.username.dirty)
    {
      if(this.username.hasError('required'))
        ans="Email can not be null";
    }
    return ans;
  }

  validatepassword()
  {
    let pass="";
    if(this.password.dirty && this.password.invalid)
    pass="Pin should be  of length 4";
    return pass;
  }

  signIn()
  {
    let tok;
    let data={"userid":this.username.value,"password":this.password.value};
    console.log(data);
    this.authserv.getTokenfromserver(data).subscribe
    (
      (res)=>
      {
          console.log(res)
          tok=res["token"];
          this.authserv.storeToken(tok);
      },err => alert("Invalid user")
    )
   
  }
}
