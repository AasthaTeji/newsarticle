import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SignupComponent} from './signup/signup.component';
import {LoginComponent} from './login/login.component';
import {NewsComponent} from './news/news.component';
import {FindanalystComponent} from './findanalyst/findanalyst.component';

const routes: Routes = [
  { path: 'signup', component: SignupComponent },
  { path: '', component: LoginComponent },
  { path: 'news', component: NewsComponent },
  { path: 'findanalyst', component: FindanalystComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
