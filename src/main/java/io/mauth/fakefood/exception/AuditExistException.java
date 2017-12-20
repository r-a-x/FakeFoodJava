package io.mauth.fakefood.exception;

/**
 * Created by rahulb on 7/12/17.
 */
public class AuditExistException extends RuntimeException{

    private String message;

    public AuditExistException(String message) {
        super(message);
    }
}
