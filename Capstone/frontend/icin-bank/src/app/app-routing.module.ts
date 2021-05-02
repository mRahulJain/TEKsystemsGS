import { TransferComponent } from './components/bank/transfer/transfer.component';
import { AccountsComponent } from './components/bank/accounts/accounts.component';
import { ProfileComponent } from './components/bank/profile/profile.component';
import { UserRoutingService } from './services/routing-service/user-routing.service';
import { BankComponent } from './components/bank/bank/bank.component';
import { HomeComponent } from './components/bank/home/home.component';
import { UserServiceService } from './services/users/user-service.service';
import { RegistrationComponent } from './components/auth/registration/registration.component';
import { LoginComponent } from './components/auth/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DataService } from './services/current-user/data.service';
import { AccountService } from './services/account/account.service';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegistrationComponent},
  {path: 'bank', component: BankComponent, canActivateChild: [UserRoutingService],
      children: [
    {path: 'home', component: HomeComponent},
    {path: 'profile', component: ProfileComponent},
    {path: 'accounts', component: AccountsComponent},
    {path: 'transfer', component: TransferComponent}
  ]}
];

@NgModule({
  providers: [ UserServiceService, DataService, UserRoutingService, AccountService ],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
