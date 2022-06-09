import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditComponent } from './edit/edit.component';
import { ProfileSettingComponent } from './profile-setting/profile-setting.component';

const routes: Routes = [{path:'edit', component: EditComponent},
                        {path:'usersetting',component:ProfileSettingComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
