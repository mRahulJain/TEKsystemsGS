import { Component, OnInit } from '@angular/core';
import { Question } from '../models/question';
import { Quiz } from '../models/quiz';
import { HelperService } from '../service/helper.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-quiz-review',
  templateUrl: './quiz-review.component.html',
  styleUrls: ['./quiz-review.component.css']
})
export class QuizReviewComponent implements OnInit {

  quiz: Quiz = new Quiz(null);
  pager = {
    index: 0,
    size: 1,
    count: 1
  };

  constructor(
    private helperService: HelperService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.quiz = this.helperService.getQuiz();
  }

  onBack() {
    this.location.back();
  }

  checkIfAnswered(question: Question) {
    return question.options.find(x => x.selected) ? 'Answered' : 'Not Answered';
  };

}
