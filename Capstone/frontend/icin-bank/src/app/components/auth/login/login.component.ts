import { DataService } from './../../../services/current-user/data.service';
import { UserServiceService } from './../../../services/users/user-service.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginUserId: string = '';
  loginUserPassword: string = '';

  constructor(private router: Router, private userService: UserServiceService, private dataService: DataService) { }

  ngOnInit(): void {
  }

  loginUser() {
    if(this.loginUserId ==='' || this.loginUserPassword === '') {
      alert('Please enter above credentials!');
      return;
    }

    this.userService
    .checkUserByIdAndPassword(this.loginUserId, this.loginUserPassword)
    .subscribe(
      message => {
        if(message.message === 'success') {
          this.userService.getUser(this.loginUserId).subscribe(
            user => {
              this.dataService.setUser(user);
              this.dataService.setIsSafe(true);
              this.router.navigate(['bank/home']);
            }
          )
        } else {
          alert(message.message);
        }
      },
      error => console.log(error)
    )
  }

}
