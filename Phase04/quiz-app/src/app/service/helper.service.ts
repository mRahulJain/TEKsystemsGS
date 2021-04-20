import { Injectable } from '@angular/core';
import { Quiz } from '../models/quiz';

@Injectable({
  providedIn: 'root'
})
export class HelperService {

  public quiz: Quiz
  public isSafe: boolean = false
  constructor() { }

  public getQuiz() {
    return this.quiz;
  }

  public setQuiz(quiz: Quiz) {
    this.quiz = quiz;
  }

  public getIsSafe() {
    return this.isSafe;
  }

  public setIsSafe(isSafe: boolean) {
    this.isSafe = isSafe
  }

}
