import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { LoginComponent } from './components/auth/login/login.component';
import { RegistrationComponent } from './components/auth/registration/registration.component';
import { FooterComponent } from './components/footer/footer.component';
import { FormsModule } from '@angular/forms';
import { UserServiceService } from './services/users/user-service.service';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/bank/home/home.component';
import { BankComponent } from './components/bank/bank/bank.component';
import { DataService } from './services/current-user/data.service';
import { ProfileComponent } from './components/bank/profile/profile.component';
import { AccountsComponent } from './components/bank/accounts/accounts.component';
import { AccountService } from './services/account/account.service';
import { TransferComponent } from './components/bank/transfer/transfer.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    RegistrationComponent,
    FooterComponent,
    HomeComponent,
    BankComponent,
    ProfileComponent,
    AccountsComponent,
    TransferComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ UserServiceService, DataService, AccountService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
