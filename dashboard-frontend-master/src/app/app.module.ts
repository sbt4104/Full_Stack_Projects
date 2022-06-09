import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import {MatDialogModule, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {MatToolbarModule} from '@angular/material/toolbar';
import {BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import { AddportfolioComponent } from './addportfolio/addportfolio.component';
import { RouterserviceService } from './routerservice.service';
import { RouterModule, Routes } from '@angular/router';
import { TradeComponent } from './trade/trade.component';
import { PortfolioService } from './portfolio.service';
import { GridviewComponent } from './gridview/gridview.component';
import { CardviewComponent } from './cardview/cardview.component';
import { ListStocksComponent } from './list-stocks/list-stocks.component';


const appRoutes: Routes = [
  {
    path: 'add',
    component: AddportfolioComponent
  },
  {
    path:'trade',
    component:TradeComponent
  },
  {
    path: 'header',
    component :HeaderComponent,
    children: [
      {
        path: 'gridview',
        component : GridviewComponent
      },
      {
        path:'',
        redirectTo: 'gridview',
        pathMatch: 'full'
      }
    ]
  },
  {
    path:'',
    redirectTo: '',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AddportfolioComponent,
    TradeComponent,
    GridviewComponent,
    CardviewComponent,
    ListStocksComponent
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
    MatSelectModule,MatButtonModule,MatCardModule,MatIconModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [RouterserviceService,PortfolioService],
  exports: [RouterModule],
  bootstrap: [AppComponent],
  entryComponents:[AddportfolioComponent,TradeComponent,ListStocksComponent]
})
export class AppModule { }
