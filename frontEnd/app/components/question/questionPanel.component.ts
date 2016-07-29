import {Component, Input} from '@angular/core';
import {Question} from '../../model/question';

@Component({
    selector: 'question-panel',
    templateUrl: 'app/templates/question/questionPanel.html'
})
export class QuestionPanel {
    @Input() question: Question;
    @Input() questionIndex: number;
    answerVisible: boolean = false;
    includeWrong: boolean = true;
    wrongAnswerButton: String = "Exclude wrong answers";
    
    toggleQuestionPanel(): void {
        this.answerVisible = !this.answerVisible;
    }
    
    toggleIncludeWrong(): void {
        this.includeWrong = !this.includeWrong;
        if (!this.includeWrong) {
            this.wrongAnswerButton= "Include wrong answers";
        } else {
            this.wrongAnswerButton= "Exclude wrong answers";
        }
    }
    
    calculateBadAnswersList(): Array<String> {
        if (this.includeWrong) {
            return this.question.getBadAnswers();
        }
        return [];
    }
}