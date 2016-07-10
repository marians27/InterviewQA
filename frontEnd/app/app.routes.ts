import {provideRouter, RouterConfig} from '@angular/router';
import {HomePage} from './components/home/homePage.component';
import {QuestionList} from './components/question/questionList.component';
import {QuestionCreator} from './components/question/questionCreator.component';
import {Categories} from './components/question/categories.component';
import {QuestionContainer} from './components/question/questionContainer.component';
import {TestContainer} from './components/test/testContainer.component';
import {TestSheet} from './components/test/testSheet.component';

export const routes: RouterConfig = [
    { path: '', component: HomePage },
    { path: 'home', component: HomePage },
    {
        path: 'questions', 
        component: QuestionContainer,
        children: [
            {
                path: 'list',
                component: QuestionList
            }, {
                path: 'create',
                component: QuestionCreator
            }, {
                path: 'categories',
                component: Categories
            }
        ]
    },
    {
        path: 'tests', 
        component: TestContainer,
        children: [
            {
                path: 'solve',
                component: TestSheet
            }
        ]
    }
];

export const APP_ROUTER_PROVIDERS = [
  provideRouter(routes)
];