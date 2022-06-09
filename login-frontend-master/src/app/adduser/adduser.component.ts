import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent implements OnInit {

  constructor(private authserv : AuthenticationService) { }

  ngOnInit(): void {
  }
  username = new FormControl('',Validators.required);
  password = new FormControl('',Validators.minLength(4));

  validateName()
  {
    let ans="";
    if(this.username.touched && this.username.dirty)
    {
      if(this.username.hasError('required'))
        ans="Name can not be null";
    }
    return ans;
  }

  validatepassword()
  {
    let pass="";
    if(this.password.dirty && this.password.invalid)
    pass="Password should be minimum of length 4";

    return pass;
    
  }
  signUp()
  {
    let tok;
    let data={"userid":this.username.value,"password":this.password.value};
    this.authserv.adduser(data).subscribe
    (
      (res)=>
      {
          console.log(res);
          alert("User Added"); 
      }

    )
   
  }
}
