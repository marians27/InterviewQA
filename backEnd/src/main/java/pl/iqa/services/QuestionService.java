package pl.iqa.services;

import com.google.common.base.Joiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.iqa.model.question.Question;
import pl.iqa.repository.QuestionRepository;
import pl.iqa.services.exception.CustomValidationException;

import java.util.List;

import static com.google.common.base.MoreObjects.firstNonNull;

@Service
public class QuestionService {

    private static final Integer DEFAULT_PAGE_SIZE = 10;
    private static final Integer DEFAULT_PAGE_NUMBER = 1;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CategoryService categoryService;

    public List<Question> retrieveQuestions(Integer pageNumberParam, Integer pageSizeParam) {
        int pageNumber = firstNonNull(pageNumberParam, DEFAULT_PAGE_NUMBER);
        int pageSize = firstNonNull(pageSizeParam, DEFAULT_PAGE_SIZE);
        int startIndex = startIndex(pageNumber, pageSize);
        int endIndex = endIndex(pageNumber, pageSize);
        return questionRepository.loadQuestions(startIndex, endIndex);
    }

    private int endIndex(Integer pageNumber, Integer pageSize) {
        return pageNumber * pageSize;
    }

    private int startIndex(Integer pageNumber, Integer pageSize) {
        return (pageNumber - 1) * pageSize;
    }

    public void createQuestion(Question question) {
        List<String> notExistingCategories = categoryService.notExistingCategories(question.getCategories());
        if (!notExistingCategories.isEmpty()) {
            throw new CustomValidationException("categories",
                    "Categories " + Joiner.on(", ").join(notExistingCategories) + " do not exists");
        }
        questionRepository.createQuestion(question);
    }

}
