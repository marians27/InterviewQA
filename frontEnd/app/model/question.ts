export class Question {
    private questionText: String;
    private correctAnswers: Array<String>;
    private badAnswers: Array<String>;

    constructor(questionText: String, correctAnswers: Array<String>, badAnswers: Array<String>) {
        this.questionText = questionText;
        this.correctAnswers = correctAnswers;
        this.badAnswers = badAnswers;
    }
    
    getBadAnswers(): Array<String> {
        return this.badAnswers;
    }

}