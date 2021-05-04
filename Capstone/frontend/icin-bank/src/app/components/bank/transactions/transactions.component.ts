import { AccountService } from './../../../services/account/account.service';
import { DataService } from './../../../services/current-user/data.service';
import { TransactionsService } from 'src/app/services/transactions/transactions.service';
import { Component, OnInit } from '@angular/core';
import { Transactions } from 'src/app/model/transactions';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {

  transactions : Array<Transactions>
  toShowTransactions: Array<Transactions>
  allowBack: boolean = false;
  allowNext: boolean = false;
  current: number;

  constructor(
    private dataService: DataService, 
    private transactionsService: TransactionsService,
    private accountService: AccountService
  ) { }

  ngOnInit(): void {
    this.transactionsService.getTransactions(this.dataService.getUser().accountNumber)
    .subscribe(
      transactions => {
        if(transactions.length>5) {
          this.allowNext = true;
        }
        this.transactions = transactions;
        this.current = 0;
        this.toShowTransactions = this.transactions.slice(this.current,this.current+5);
      },
      error => console.log(error)
    )
  }

  onPrev() {
    this.allowNext = true;
    this.current = this.current-5;
    this.toShowTransactions = this.transactions.slice(this.current,this.current+5);
    if(this.current-5<0) {
      this.allowBack = false;
    } else {
      this.allowBack = true;
    }
  }

  onNext() {
    this.allowBack = true;
    this.current = this.current+5;
    this.toShowTransactions = this.transactions.slice(this.current,this.current+5);
    if(this.current+5>=this.transactions.length) {
      this.allowNext = false;
    } else {
      this.allowNext = true;
    }
  }

  generateDate(date: Date) : string {
    let myDate = `${date}`.slice(0,10);
    return myDate;
  }

  generateStatus(code: number) : string {
    if(code===1) {
      return 'Success';
    }
    return 'Pending';
  }

  checkSelf(accountNumber: string) : string {
    if(this.dataService.getUser().accountNumber === accountNumber) {
      return 'Self'
    }
    return accountNumber;
  }

  generateType(from: string, to: string) : string {
    let curr_acc = this.dataService.getUser().accountNumber;
    if(to === curr_acc && from === curr_acc) {
      return '-';
    }
    if(to === curr_acc) {
      return 'Credit'
    }
    return 'Debit'
  }

  onRefresh() {
    this.transactionsService.getTransactions(this.dataService.getUser().accountNumber)
    .subscribe(
      transactions => {
        if(transactions.length>5) {
          this.allowNext = true;
        }
        this.transactions = transactions;
        this.current = 0;
        this.toShowTransactions = this.transactions.slice(this.current,this.current+5);
      },
      error => console.log(error)
    )
  }

}
