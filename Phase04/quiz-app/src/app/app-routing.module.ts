import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DefaultComponent } from './default/default.component';
import { QuizResultComponent } from './quiz-result/quiz-result.component';
import { QuizReviewComponent } from './quiz-review/quiz-review.component';
import { QuizComponent } from './quiz/quiz.component';
import { RouteGuardService } from './service/route-guard.service';

const routes: Routes = [
  {path: 'quiz', component: QuizComponent},
  {path: 'quiz-review', component: QuizReviewComponent, canActivate: [RouteGuardService]},
  {path: 'quiz-result', component: QuizResultComponent, canActivate: [RouteGuardService]},
  { path: '**', component: DefaultComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
