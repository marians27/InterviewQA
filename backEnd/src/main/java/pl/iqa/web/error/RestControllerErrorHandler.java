package pl.iqa.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.iqa.model.error.OperationError;
import pl.iqa.model.error.ValidationError;
import pl.iqa.repository.exceptions.EntityExistsException;
import pl.iqa.services.exception.CustomValidationException;
import pl.iqa.services.exception.EntityNotFoundException;

import java.util.List;

import static java.util.stream.Collectors.toList;

@ControllerAdvice
public class RestControllerErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<ValidationError> handleValidationError(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        return fieldErrors.stream()
                .map(this::processFieldError)
                .collect(toList());
    }

    @ExceptionHandler(CustomValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationError handleCustomValidationException(CustomValidationException exception) {
        return new ValidationError(exception.getField(), exception.getMessage());
    }

    @ExceptionHandler(EntityExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public OperationError handleEntityExistsException(EntityExistsException exception) {
        return new OperationError(exception.getMessage());
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public OperationError handleUnsupportedOperationException(UnsupportedOperationException exception) {
        return new OperationError(exception.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public OperationError handleEntityNotFoundException(EntityNotFoundException exception) {
        return new OperationError(exception.getMessage());
    }

    private ValidationError processFieldError(FieldError fieldError) {
        return new ValidationError(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
