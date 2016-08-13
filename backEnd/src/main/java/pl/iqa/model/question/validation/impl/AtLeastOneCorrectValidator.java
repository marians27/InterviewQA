package pl.iqa.model.question.validation.impl;

import pl.iqa.model.question.Answer;
import pl.iqa.model.question.validation.AtLeastOneCorrect;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Objects;

public class AtLeastOneCorrectValidator implements ConstraintValidator<AtLeastOneCorrect, List<Answer>> {

    @Override
    public void initialize(AtLeastOneCorrect constraintAnnotation) {
    }

    @Override
    public boolean isValid(List<Answer> value, ConstraintValidatorContext context) {
        return value != null && value.stream()
                .map(Answer::getIsCorrect)
                .filter(Objects::nonNull)
                .filter(isCorrect -> isCorrect)
                .findAny()
                .isPresent();
    }
}
