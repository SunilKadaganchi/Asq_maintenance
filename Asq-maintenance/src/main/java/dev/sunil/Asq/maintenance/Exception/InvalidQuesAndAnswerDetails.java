package dev.sunil.Asq.maintenance.Exception;

public class InvalidQuesAndAnswerDetails extends RuntimeException{
    public InvalidQuesAndAnswerDetails() {
    }

    public InvalidQuesAndAnswerDetails(String message) {
        super(message);
    }

    public InvalidQuesAndAnswerDetails(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidQuesAndAnswerDetails(Throwable cause) {
        super(cause);
    }

    public InvalidQuesAndAnswerDetails(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
