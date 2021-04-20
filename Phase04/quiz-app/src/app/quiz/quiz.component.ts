import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Config } from '../models/config';
import { Option } from '../models/option';
import { Question } from '../models/question';
import { Quiz } from '../models/quiz';
import { HelperService } from '../service/helper.service';
import { HttpClientService } from '../service/http-client.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {

  quiz: Quiz = new Quiz(null);
  quizName: string;
  config: Config = {
    'allowBack': false,
    'allowNext': true,
    'allowReview': true,
    'pageSize': 1,
    'requiredAll': false,
  };

  pager = {
    index: 0,
    size: 1,
    count: 1
  };

  constructor(
    private helperService: HelperService,
    private httpClientService: HttpClientService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.quiz = this.helperService.getQuiz();
    if(this.quiz == null) {
      this.quizName = 'data/chemistry.json';
      this.initQuiz(this.quizName);
      return;
    }
    this.pager.count = this.quiz.questions.length;
  }

  initQuiz(quizName: string) {
    this.httpClientService.get(quizName).subscribe(res => {
      this.quiz = new Quiz(res);
      this.pager.count = this.quiz.questions.length;
    });
  }

  get setQuestion() {
    return (this.quiz.questions) ?
      this.quiz.questions.slice(this.pager.index, this.pager.index + this.pager.size) : [];
  }

  markOption(question: Question, option: Option) {
    question.options.forEach((x) => { if (x.id !== option.id) x.selected = false; });
  }

  navigate(index: number) {
    if (index >= 0 && index < this.pager.count) {
      this.pager.index = index;
    }
    if(index == 0) {
      this.config.allowBack = false;
      this.config.allowNext = true;
    } else if(index == this.pager.count-1) {
      this.config.allowBack = true;
      this.config.allowNext = false;
    } else {
      this.config.allowBack = true;
      this.config.allowNext = true;
    }
  }

  isCorrect(question: Question) {
    return question.options.every(x => x.selected === x.isAnswer) ? 'correct' : 'wrong';
  };

  onReview() {
    this.helperService.setIsSafe(true);
    this.helperService.setQuiz(this.quiz);
    this.router.navigate(['quiz-review']);
  }

  onSubmit() {
    this.helperService.setIsSafe(true);
    this.helperService.setQuiz(this.quiz);
    this.router.navigate(['quiz-result']);
  }

}
