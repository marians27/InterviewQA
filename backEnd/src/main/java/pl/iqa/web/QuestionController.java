package pl.iqa.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @RequestMapping(method = RequestMethod.GET)
    public String getQuestions() {
        return "mock";
    }
}
