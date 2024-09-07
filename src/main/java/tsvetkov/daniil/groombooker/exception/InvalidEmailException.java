package tsvetkov.daniil.groombooker.exception;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String message) {
        super(message);
    }
    public InvalidEmailException() {
        super("Email не соответствует шаблону");
    }
}
