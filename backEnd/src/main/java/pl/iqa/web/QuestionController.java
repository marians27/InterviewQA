package pl.iqa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.iqa.model.question.Question;
import pl.iqa.services.QuestionService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Question> getQuestions(@RequestParam(required = false, name = "pageNumber") Integer pageNumber,
                                       @RequestParam(required = false, name = "pageSize") Integer pageSize) {
        return questionService.retrieveQuestions(pageNumber, pageSize);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void postQuestion(@RequestBody @Valid Question question) {
        questionService.createQuestion(question);
    }

}
