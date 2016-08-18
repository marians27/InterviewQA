package pl.iqa.model.question.validation.impl;

import pl.iqa.model.question.validation.UniqueElements;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collection;

public class UniqueElementsValidator implements ConstraintValidator<UniqueElements, Collection<?>> {

    @Override
    public void initialize(UniqueElements constraintAnnotation) {

    }

    @Override
    public boolean isValid(Collection<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.size() == value.stream().distinct().count();
    }
}
