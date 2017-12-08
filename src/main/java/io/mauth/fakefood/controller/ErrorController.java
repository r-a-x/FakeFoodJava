package io.mauth.fakefood.controller;

import io.mauth.fakefood.dto.ErrorDto;
import io.mauth.fakefood.exception.FileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by rahulb on 4/11/17.
 */
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto processFileNotFoundException(Exception e) {
        return new ErrorDto("file_not_found", e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDto processAuthenticationError(Exception e) {
        return new ErrorDto("internal_server_error", e.getMessage());
    }

}
