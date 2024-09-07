package tsvetkov.daniil.groombooker.exception;

public class InvalidPhoneNumberException extends RuntimeException {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }

    public InvalidPhoneNumberException() {
        super("Недопустимая для номера телефона или содержит недопустимые символы");
    }
}
