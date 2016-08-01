import {Injectable} from '@angular/core';
import {Question} from '../model/question';

@Injectable()
export class QuestionService {
    
    createQuestion(question: Question): void {
        console.log("Created question: " + JSON.stringify(question));
    }
    
    loadQuestions(page: number, pageSize: number): Array<Question> {
        if (page == 1) {
            return [
                new Question(
                    "What is Java?", 
                    ["Programming language"], 
                    ["Application server", "Operationg system", "Type of processor"],
                    ["Java", "Programming"]),
                new Question(
                    "What is JVM?",
                    ["Java virtual machine", "Environment in which java program is executed"],
                    ["Programming language", "Operating system", "Processor type"],
                    ["JVM"]
                )];
        } else if (page == 2) {
            return [
                new Question(
                    "What is REST?", 
                    ["Architectural style often used for building web services", "Representational State Transfer"], 
                    ["Programming language used to build web services", "Framework for building web services"],
                    ["Patterns"]),
                new Question(
                    "Which of following can be connected with REST?",
                    ["Resource", "Uniform interfaxe", "HATEOAS", "HTTP"],
                    ["SOAP", "RPC", "Action"],
                    []
                )];
        } else {
            return [];
        }
    }
}