import {Component} from '@angular/core';
import {Answer} from '../../model/answer';
import {Question} from '../../model/question';
import {MultiValueDropdown} from '../util/multiValueDropdown.component';
import {QuestionService} from '../../services/question.service';
import {CategoryService} from '../../services/category.service';

@Component({
    selector: 'question-creator',
    templateUrl: 'app/templates/question/questionCreator.html',
    directives: [MultiValueDropdown]
})
export class QuestionCreator {
    private availableCategories: Array<string>;
    private answers: Array<Answer> = [new Answer()];
    private questionText: String;
    private categories: Array<String> = [];
    
    private questionService: QuestionService;
    
    constructor(questionService: QuestionService, categoryService: CategoryService) {
        this.questionService = questionService;
        this.availableCategories = categoryService.loadCategoryLabels();
    }
    
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
        var question: Question = new Question(this.questionText, correctAnswers, badAnswers, this.categories);
        this.questionService.createQuestion(question);
    }


} 