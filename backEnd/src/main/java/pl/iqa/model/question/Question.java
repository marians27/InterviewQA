package pl.iqa.model.question;

import pl.iqa.model.question.validation.AtLeastOneCorrect;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public class Question {

    @NotNull
    private String questionText;

    @AtLeastOneCorrect
    @Valid
    private List<Answer> answers;

    @Valid
    private List<Category> categories;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(questionText, question.questionText) &&
                Objects.equals(answers, question.answers) &&
                Objects.equals(categories, question.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionText, answers, categories);
    }
}
