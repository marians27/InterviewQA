import {Component} from '@angular/core';
import {ROUTER_DIRECTIVES } from '@angular/router';
import {HomePage} from './home/homePage.component';
import {QuestionList} from './question/questionList.component';

@Component({
    selector: 'my-app',
    templateUrl: 'app/templates/app.html',
    directives: [ROUTER_DIRECTIVES],
    precompile: [HomePage, QuestionList]
})
export class AppComponent {
    private questionsMenuEnabled: boolean = false;
    private testsMenuEnabled: boolean = false;
    
    toogleQuestionsMenu(): void {
        this.questionsMenuEnabled = !this.questionsMenuEnabled;
        this.testsMenuEnabled = false;
    }
    
    toogleTestsMenu(): void {
        this.testsMenuEnabled = !this.testsMenuEnabled;
        this.questionsMenuEnabled = false;
    }
    
    hideAll(event): void {
        if (!event.target.matches('.dropdown-toggle')) {
            this.questionsMenuEnabled = false;
            this.testsMenuEnabled = false;
        }
    }
}