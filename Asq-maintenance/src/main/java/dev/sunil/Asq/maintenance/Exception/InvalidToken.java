package dev.sunil.Asq.maintenance.Exception;

public class InvalidToken extends RuntimeException{
    public InvalidToken() {
    }

    public InvalidToken(String message) {
        super(message);
    }

    public InvalidToken(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidToken(Throwable cause) {
        super(cause);
    }

    public InvalidToken(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
