package io.mauth.fakefood.exception;

/**
 * Created by rahulb on 7/12/17.
 */
public class FileNotFoundException  extends RuntimeException{

    private String message;

    public FileNotFoundException(String message) {
        super(message);
    }
}
