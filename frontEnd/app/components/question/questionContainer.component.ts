import {Component} from '@angular/core';
import {ROUTER_DIRECTIVES} from '@angular/router'
import {QuestionService} from "../../services/question.service";

@Component({
    selector: 'question',
    template: '<router-outlet></router-outlet>',
    providers: [QuestionService],
    directives: [ROUTER_DIRECTIVES]
})
export class QuestionContainer {
    
}