export class Question {
    private questionText: String;
    private correctAnswers: Array<String>;
    private badAnswers: Array<String>;
    private categories: Array<String>;

    constructor(questionText: String, correctAnswers: Array<String>, badAnswers: Array<String>, categories: Array<String>) {
        this.questionText = questionText;
        this.correctAnswers = correctAnswers;
        this.badAnswers = badAnswers;
        this.categories = categories;
    }
    
    getBadAnswers(): Array<String> {
        return this.badAnswers;
    }

}