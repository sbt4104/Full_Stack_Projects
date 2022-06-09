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


const myroutes: Routes =[
  {
    path:'dashboard',
    component:DashboardComponent
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
    path:'',
    redirectTo:'dashboard',
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
    MylistComponent
    
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
    RouterModule.forRoot(myroutes),
    MatTabsModule,
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    HttpClientModule,
    MatCardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
