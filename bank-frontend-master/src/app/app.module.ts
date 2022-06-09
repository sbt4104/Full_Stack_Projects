import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BankdashboardComponent } from './bankdashboard/bankdashboard.component';

import {HttpClientModule} from '@angular/common/http';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import {MatDialogModule, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {MatToolbarModule} from '@angular/material/toolbar';

import {MatExpansionModule} from '@angular/material/expansion';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import { AddbankComponent } from './addbank/addbank.component';
import { BankgridviewComponent } from './bankgridview/bankgridview.component';
import { BankcardviewComponent } from './bankcardview/bankcardview.component';
import { BankupdateComponent } from './bankupdate/bankupdate.component';





@NgModule({
  declarations: [
    AppComponent,
    BankdashboardComponent,
    AddbankComponent,
    BankgridviewComponent,
    BankcardviewComponent,
    BankupdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,ReactiveFormsModule,
    MatDialogModule,
    MatToolbarModule,
    MatExpansionModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,MatButtonModule,MatCardModule,MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents:[AddbankComponent]
})
export class AppModule { }
