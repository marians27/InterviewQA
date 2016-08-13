package pl.iqa.model.question.validation;

import pl.iqa.model.question.validation.impl.AtLeastOneCorrectValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AtLeastOneCorrectValidator.class)
public @interface AtLeastOneCorrect {

    String ERROR_MESSAGE = "{pl.iqa.model.question.validation.AtLeastOneCorrect}";

    String message() default ERROR_MESSAGE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
