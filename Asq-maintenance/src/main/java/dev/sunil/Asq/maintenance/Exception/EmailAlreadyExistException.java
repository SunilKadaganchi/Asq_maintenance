package dev.sunil.Asq.maintenance.Exception;


public class EmailAlreadyExistException extends RuntimeException {
    public EmailAlreadyExistException() {
    }

    public EmailAlreadyExistException(String message) {
        super(message);
    }

    public EmailAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public EmailAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
