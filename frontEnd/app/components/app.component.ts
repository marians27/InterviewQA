import {Component} from '@angular/core';

@Component({
    selector: 'my-app',
    templateUrl: 'app/templates/app.html'
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