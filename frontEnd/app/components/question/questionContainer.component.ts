import {Component} from '@angular/core';
import {ROUTER_DIRECTIVES} from '@angular/router'
import {QuestionService} from "../../services/question.service";
import {CategoryService} from "../../services/category.service";

@Component({
    selector: 'question',
    template: '<router-outlet></router-outlet>',
    providers: [QuestionService, CategoryService],
    directives: [ROUTER_DIRECTIVES]
})
export class QuestionContainer {
    
}