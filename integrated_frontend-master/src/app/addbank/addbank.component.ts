import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Bank } from '../Bank';
import { BankService } from '../bank.service';

@Component({
  selector: 'app-addbank',
  templateUrl: './addbank.component.html',
  styleUrls: ['./addbank.component.css']
})
export class AddbankComponent implements OnInit {
  bank_obj:Bank;
  errMessage:string="";
  account_number= new FormControl('',Validators.required);
  bank_name= new FormControl('',Validators.required);
  bank_ifsc= new FormControl('',Validators.required);

  constructor(private bank_service:BankService,private dialog:MatDialog) 
  {
    this.bank_obj=new Bank();
  }
 validateAccount()
  {
    let ans="";
    if(this.account_number.touched && this.account_number.dirty)
    {
      if(this.account_number.hasError('required'))
        ans="This account_number can not be null";
    }
    return ans;
  }
  validateName()
  {
    let ans="";
    if(this.bank_name.touched && this.bank_name.dirty)
    {
      if(this.bank_name.hasError('required'))
        ans="This Field can not be null";
    }
    return ans;
  }
  validateIfsc()
  {
    let ans="";
    if(this.bank_ifsc.touched && this.bank_ifsc.dirty)
    {
      if(this.bank_ifsc.hasError('required'))
        ans="This Field can not be null";
    }
    return ans;
  }
  ngOnInit(): void 
  {

  }
  save()
  {
  
    if (this.bank_obj.account_number.length==0 || this.bank_obj.bank_name.length==0 
      || this.bank_obj.ifsc_code.length==0) 
    {
      this.errMessage = 'All are mandatory fields';
      return;
    }
    let data=
    {
      "account_number":this.bank_obj.account_number,
      "bank_name":this.bank_obj.bank_name,
      "ifsc_code":this.bank_obj.ifsc_code
    }
   
    this.bank_service.addBank(this.bank_service.getid(),data).subscribe(
      (res) => {
        console.log('res: ');
        console.log(res);
      },
      (err) => {
        console.log('errored: ' + err.message);
        alert(err.message);
        // if (err.error === undefined) {
        //   this.submitMessage = err.message;
        // } else {
        //   this.submitMessage = err.error.message;
        // }
        // console.log('after');
      }

    );
    this.dialog.closeAll();
    

  }



}
