import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatInputModule} from '@angular/material/input';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserSettingComponent } from './user-setting/user-setting.component';
import { EditComponent } from './edit/edit.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { UpdateProfileService } from './update-profile.service';

@NgModule({
  declarations: [
    AppComponent,
    UserSettingComponent,
    EditComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
     FormsModule,
     MatButtonModule,
     AppRoutingModule,
     MatCardModule,
     MatFormFieldModule,
     BrowserAnimationsModule,
     ReactiveFormsModule,
     MatInputModule
  ],
  providers: [UpdateProfileService],
  bootstrap: [AppComponent]
})
export class AppModule { }
