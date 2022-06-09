import { Inject } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Bank } from '../Bank';
import { BankService } from '../bank.service';

@Component({
  selector: 'app-bankupdate',
  templateUrl: './bankupdate.component.html',
  styleUrls: ['./bankupdate.component.css']
})
export class BankupdateComponent implements OnInit 
{

  acc_number:string="";
  bank_obj:Bank;
  errMessage:string="";
  bank_name= new FormControl('',Validators.required);
  bank_ifsc= new FormControl('',Validators.required);
  
  constructor(private dialog:MatDialog,private bank_service:BankService,@Inject(MAT_DIALOG_DATA) data:any) 
  {
    this.acc_number=data;
    this.bank_obj=new Bank();  
  }

  ngOnInit(): void {
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

  update()
  {
    if (this.bank_obj.bank_name.length==0 || this.bank_obj.ifsc_code.length==0) 
    {
      this.errMessage = 'All are mandatory fields';
      return;
    }
    let data=
    {
      "account_number":this.acc_number,
      "bank_name":this.bank_obj.bank_name,
      "ifsc_code":this.bank_obj.ifsc_code
    }
    this.bank_service.updateBank(this.bank_service.getid(),data).subscribe();
    this.dialog.closeAll();
  }

}


