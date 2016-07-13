import {Component} from '@angular/core';
import {Answer} from '../../model/answer';
import {Question} from '../../model/question';

@Component({
    selector: 'question-creator',
    templateUrl: 'app/templates/question/questionCreator.html'
})
export class QuestionCreator {
    private answers: Array<Answer> = [new Answer()];
    private questionText: String;

    addAnswer(): void {
        this.answers.push(new Answer());
    }

    createQuestion(): void {
        var correctAnswers: Array<String> = [];
        var badAnswers: Array<String> = [];
        for (var answer of this.answers) {
            if (answer.isCorrect && answer.answerText != null) {
                correctAnswers.push(answer.answerText);
            } else if (answer.answerText != null) {
                badAnswers.push(answer.answerText);
            }
        }
        var question: Question = new Question(this.questionText, correctAnswers, badAnswers);
        console.log(JSON.stringify(question));
    }


} 