import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import {RouterModule, Routes} from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WatchlistComponent } from './watchlist/watchlist.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import {MatIconModule} from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav';
import { SidebarModule } from 'ng-sidebar';
import { NavigationComponent } from './navigation/navigation.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatButtonModule } from '@angular/material/button';
import { MatListModule } from '@angular/material/list';
import { AvatarComponent } from './avatar/avatar.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProfileSettingComponent } from './profile-setting/profile-setting.component';
import {MatTabsModule} from '@angular/material/tabs';
import {MatTableModule} from '@angular/material/table';
import { SearchComponent } from './search/search.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';
import {HttpClientModule} from '@angular/common/http';
import { WatchlistcardviewComponent } from './watchlistcardview/watchlistcardview.component';
import { MylistComponent } from './mylist/mylist.component';


import { PortheaderComponent } from './portheader/portheader.component';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import {MatDialogModule, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

import {MatExpansionModule} from '@angular/material/expansion';
import {MatSelectModule} from '@angular/material/select';
import { AddportfolioComponent } from './addportfolio/addportfolio.component';
import { TradeComponent } from './trade/trade.component';
import { PortfolioService } from './portfolio.service';
import { GridviewComponent } from './gridview/gridview.component';
import { CardviewComponent } from './cardview/cardview.component';
import { ListStocksComponent } from './list-stocks/list-stocks.component';
import { MyRouteService } from './my-router.service';
import { WatchlistService } from './watchlist.service';


import { BankdashboardComponent } from './bankdashboard/bankdashboard.component';
import { AddbankComponent } from './addbank/addbank.component';
import { BankgridviewComponent } from './bankgridview/bankgridview.component';
import { BankcardviewComponent } from './bankcardview/bankcardview.component';
import { BankupdateComponent } from './bankupdate/bankupdate.component';
import { BankService } from './bank.service';


import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { LeftpanelComponent } from './leftpanel/leftpanel.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { FooterComponent } from './footer/footer.component';
import { WatchlisttradeComponent } from './watchlisttrade/watchlisttrade.component';
import {TrendingComponent} from './trending/trending.component'
const myroutes: Routes =[
  {
    path:'navigate',
    component:NavigationComponent,
    children: [
      {
        path:'dashboard',
        component:PortheaderComponent
      },
      {
        path:'watchlist',
        component:WatchlistComponent
      },
      {
        path:'setting',
        component:ProfileSettingComponent
      },
      {
        path:'bankdashboard',
        component:BankdashboardComponent
      },
      {
        path:'trending',
        component:TrendingComponent
      },
    ]
  },
  {
    path: 'home',
    component: HomeComponent,
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent,
      },
      {
        path: 'user',
        component: UserComponent,
        children: [
          {
            path: 'login',
            component: LoginComponent,
          },
          {
            path: 'register',
            component: RegisterComponent,
          },
        ],
      },
    ],
  },
  {
    path:'',
    redirectTo:'home/user/register',
    pathMatch:'full'
  }
]
@NgModule({
  declarations: [
    AppComponent,
    WatchlistComponent,
    NavigationComponent,
    AvatarComponent,
    DashboardComponent,
    ProfileSettingComponent,
    SearchComponent,
    WatchlistcardviewComponent,
    MylistComponent,
    AddportfolioComponent,
    TradeComponent,
    GridviewComponent,
    CardviewComponent,
    ListStocksComponent,
    PortheaderComponent,
    BankdashboardComponent,
    AddbankComponent,
    BankgridviewComponent,
    BankcardviewComponent, 
    BankupdateComponent,
    LoginComponent,
    HeaderComponent,
    LeftpanelComponent, 
    RegisterComponent,
    HomeComponent,
    UserComponent, 
    FooterComponent, WatchlisttradeComponent,
    TrendingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatToolbarModule,
    MatSidenavModule,
    SidebarModule.forRoot(),
    LayoutModule,
    MatButtonModule,
    MatListModule,
    RouterModule,
  
    MatTabsModule,
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    HttpClientModule,
    MatCardModule,
    MatExpansionModule,
    MatSelectModule,
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule,
    RouterModule.forRoot(myroutes)
  ],
  providers: [PortfolioService, MyRouteService, WatchlistService, BankService],
  bootstrap: [AppComponent],
  entryComponents:[AddportfolioComponent,TradeComponent,ListStocksComponent, BankdashboardComponent, BankgridviewComponent, BankupdateComponent, BankcardviewComponent]
})
export class AppModule { }
