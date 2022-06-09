import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { AuthenticationService } from '../authentication.service';
import { MyRouteService } from '../my-router.service';
import { RoutingService } from '../routing.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private routeobj : RoutingService,private authserv : AuthenticationService, private myroute: MyRouteService) { }

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
          //     this.routeobj.storeUserid(this.username.value);
          // this.myroute.openDashboard();
    console.log(data);
    this.authserv.getTokenfromserver(data).subscribe
    (
      (res)=>
      {
          console.log(res)
          tok=res["token"];
          this.authserv.storeToken(tok);
          this.routeobj.storeUserid(this.username.value);
          this.myroute.openDashboard();
      },err => alert("Invalid user")
    )
  }
}
