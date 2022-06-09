import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { AuthenticationService } from '../authentication.service';
import { RoutingService } from '../routing.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  constructor(
    private routeobj: RoutingService,
    private authserv: AuthenticationService
  ) {}
  message: String = '';
  ngOnInit(): void {}
  FN = new FormControl('', Validators.minLength(1));
  LN = new FormControl('', Validators.minLength(1));
  email = new FormControl('', Validators.email);
  phone = new FormControl('', Validators.maxLength(10));
  pin1 = new FormControl('', Validators.maxLength(4));
  pin2 = new FormControl('', Validators.maxLength(4));
  // FN = new FormControl('');
  // LN = new FormControl('');
  // email = new FormControl('');
  // phone = new FormControl('');
  // pin1 = new FormControl('');
  // pin2 = new FormControl('');
  validatephone(phone: any) {
    let no = phone;

    for (let i of no) {
      if (!(parseInt(i) >= 0 && parseInt(i) <= 9)) {
        return 0;
      }
    }
    return 1;
  }

  validatepin(pin1: any, pin2: any) {
    let no = pin1,
      no2 = pin2;
    if (no != no2) return 0;

    for (let i of no) {
      if (!(parseInt(i) >= 0 && parseInt(i) <= 9)) {
        return 0;
      }
    }
    return 1;
  }

  signIn() {
    let fn = this.FN.value;
    let ln = this.LN.value;
    let email = this.email.value;
    let phone = this.phone.value;
    let pin1 = this.pin1.value;
    let pin2 = this.pin2.value;

    if (this.validatephone(phone) && this.validatepin(pin1, pin2)) {
      let data = {
        userid: email,
        password: pin1,
        fn: fn,
        ln: ln,
        phone: phone,
      };
      console.log(data);
      this.authserv.adduser(data).subscribe((res) => {
        console.log(res);
        this.message = 'successfully added';
      });
    }
    else if(!this.validatepin(pin1,pin2)){
      this.message = "Pin are not same"
    }
    else{
      this.message="Couldn't add user"
    }

    // this.authserv.getTokenfromserver(data).subscribe
    // (
    //   (res)=>
    //   {
    //       console.log(res)
    //       tok=res["token"];
    //       this.authserv.storeToken(tok);
    //   },err => alert("Invalid user")
    // )
  }
}
