package tsvetkov.daniil.groombooker.exception;

public class InvalidNameException extends RuntimeException {
    public InvalidNameException(String message) {
        super(message);
    }

    public InvalidNameException() {
        super("Имя или фамилия содержит недопустимые символы");
    }
}
