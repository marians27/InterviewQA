package pl.iqa.repository;

import org.springframework.stereotype.Repository;
import pl.iqa.model.question.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.Math.min;

@Repository
public class QuestionRepository {

    // TODO: Mock implementation
    private final List<Question> questions = new CopyOnWriteArrayList<>();

    public List<Question> loadQuestions(int startIndex, int endIndex) {
        if (startIndex > questions.size()) {
            return Collections.emptyList();
        }
        return new ArrayList<>(questions.subList(startIndex, min(endIndex, questions.size())));
    }

    public void createQuestion(Question question) {
        questions.add(question);
    }

}
