import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HelperService } from '../service/helper.service';

@Component({
  selector: 'app-default',
  templateUrl: './default.component.html',
  styleUrls: ['./default.component.css']
})
export class DefaultComponent implements OnInit {

  constructor(
    private helperService: HelperService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  takeQuiz() {
    this.helperService.setQuiz(null);
    this.router.navigate(['quiz']);
  }

}
