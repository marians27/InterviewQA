import {Component, OnInit, OnDestroy} from '@angular/core';
import {Router, ROUTER_DIRECTIVES} from '@angular/router';
import {Question} from '../../model/question';
import {QuestionService} from '../../services/question.service';
import {QuestionPanel} from './questionPanel.component';

@Component({
    selector: 'question-list',
    directives: [ROUTER_DIRECTIVES, QuestionPanel],
    templateUrl: 'app/templates/question/questionList.html'
})
export class QuestionList implements OnInit, OnDestroy {
    private page: number;
    private pageSize: number;
    
    private questions: Array<Question>;
    private questionService: QuestionService;
    
    private router: Router;
    private subscription: any;
    
    private test = 22;
    
    constructor(router: Router, questionService: QuestionService) {
        this.router = router;
        this.questionService = questionService;
    }
    
    ngOnInit() {
        console.log("Init");
        this.subscription = this.router.routerState.queryParams.subscribe(params => {
            this.page = +params['page'] || 1;
            this.pageSize = +params['pageSize'] || 10;
            this.questions = this.questionService.loadQuestions(this.page, this.pageSize);
        });
        
    }
    
    ngOnDestroy() {
        console.log("Destroy. Page= " + this.page + " pagesize=" + this.pageSize);
        this.subscription.unsubscribe();
    }
    
    nextPage(): number {
        if (this.questions.length > 0) {
            return this.page + 1;
        }
        return this.page;
    }
    
    previousPage(): number {
        if (this.page > 1) {
            return this.page - 1;
        }
        return this.page;
    }
    
    toggleQuestionPanel(i: number): void {
        console.log(i);
    }
    
}