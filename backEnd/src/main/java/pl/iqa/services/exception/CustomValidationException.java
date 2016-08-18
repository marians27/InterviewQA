package pl.iqa.services.exception;

public class CustomValidationException extends RuntimeException {

    private final String field;

    public CustomValidationException(String field, String message) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
