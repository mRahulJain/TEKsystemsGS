import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Quiz } from '../models/quiz';
import { HelperService } from '../service/helper.service';

@Component({
  selector: 'app-quiz-result',
  templateUrl: './quiz-result.component.html',
  styleUrls: ['./quiz-result.component.css']
})
export class QuizResultComponent implements OnInit {

  quiz: Quiz = new Quiz(null);
  correctCount : number = 0
  constructor(
    private helperService: HelperService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.quiz = this.helperService.getQuiz();
    this.correctCount = this.getCorrectAnswerCount();
  }

  generateText() {
    if(this.correctCount < 3) {
      return 'Oops!';
    } else if(this.correctCount == 3) {
       return 'Well tried!';
    } else {
      return 'Congratulations!';
    }
  }

  getCorrectAnswerCount() {
    this.quiz.questions.forEach(question => {
      question.options.forEach(option => {
        if(option.isAnswer && option.selected) {
          this.correctCount++;
        }
      })
    });
    console.log(this.correctCount);
    return this.correctCount;
  }

  retakeQuiz() {
    this.helperService.setQuiz(null);
    this.router.navigate(['quiz']);
  }

}
