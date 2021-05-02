import { DataService } from './../../../services/current-user/data.service';
import { AccountService } from './../../../services/account/account.service';
import { Component, OnInit } from '@angular/core';
import { Accounts } from 'src/app/model/accounts';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {

  transferAccountNumber: string = '';
  selfAccountNumber: string = '';
  transferAccountType: string = '';
  selfAccountType: string = '';
  isChecked: boolean = false;
  tranferAmount: number = 0;
  myAccount: Accounts;

  constructor(private dataService: DataService, private accountService: AccountService) { }

  ngOnInit(): void {
    this.accountService.getAccountByNumber(this.dataService.getUser().accountNumber)
      .subscribe(
        account => this.myAccount = account,
        error => console.log(error)
      )
  }

  changed(event) {
    if (event.target.checked) {
      this.isChecked = true;
      this.transferAccountNumber = this.myAccount.accountNumber;
    } else {
      this.isChecked = false;
      this.transferAccountNumber = '';
    }
  }

  transferMoney() {
    if (this.transferAccountNumber === '' ||
      this.transferAccountType === '' ||
      this.selfAccountNumber === '' ||
      this.selfAccountType === '') {
      alert('You need to enter all the details above!');
      return;
    }

    if (!(this.selfAccountType === 'Savings' || this.selfAccountType === 'Primary')) {
      alert('Wrong Self Account Type! Please type either Savings or Primary only!');
      return;
    }

    if (!(this.transferAccountType === 'Savings' || this.transferAccountType === 'Primary')) {
      alert('Wrong Transfer Account Type! Please type either Savings or Primary only!');
      return;
    }

    if (!(this.selfAccountNumber === this.myAccount.accountNumber)) {
      alert('Your account number is wrong!');
      return;
    }

    if (this.isChecked) {
      if (this.selfAccountType === this.transferAccountType) {
        alert('Illegal transaction!');
        return;
      }
    }

    if (this.selfAccountType === 'Primary' && this.myAccount.accountBalancePrimary < this.tranferAmount) {
      alert( `You only have Rs. ${this.myAccount.accountBalancePrimary} in your primary account\nYou need Rs. ${Math.round(this.tranferAmount - this.myAccount.accountBalancePrimary)} more to transfer`);
      return;
    }

    if (this.selfAccountType === 'Savings' && this.myAccount.accountBalanceSavings < this.tranferAmount) {
      alert( `You only have Rs. ${this.myAccount.accountBalanceSavings} in your savings account\nYou need Rs. ${Math.round(this.tranferAmount - this.myAccount.accountBalanceSavings)} more to transfer!`);
      return;
    }
  }
}