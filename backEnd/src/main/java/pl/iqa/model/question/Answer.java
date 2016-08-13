package pl.iqa.model.question;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Answer {

    @NotNull
    private String answerText;

    @NotNull
    private Boolean isCorrect;

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(answerText, answer.answerText) &&
                Objects.equals(isCorrect, answer.isCorrect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerText, isCorrect);
    }
}
