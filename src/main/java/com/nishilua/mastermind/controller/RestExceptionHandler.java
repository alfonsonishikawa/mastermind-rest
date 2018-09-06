package com.nishilua.mastermind.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

/**
 * This class implements the handles that translate each application exception thrown by the controllers
 * into a HTTP response code, with the body holding the error message set in the exception.
 * This is needed to meet the requirements of a REST behaviour.
 */
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler{
    
    @ExceptionHandler(NonExistingGameException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final @ResponseBody String handleNonExistingGameException(Exception e, WebRequest request) {
        return genericHandleException(e)  ;
    }

    @ExceptionHandler(WrongGuessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final @ResponseBody String handleWrongGuessException(Exception e, WebRequest request) {
        return genericHandleException(e)  ;
    }
    
    private final String genericHandleException(Exception e) {
        StringBuilder strBuilder = new StringBuilder(e.getMessage() != null ? e.getMessage() : "") ;
        if (e.getCause() != null) {
        	strBuilder.append("\n");
        	strBuilder.append(e.getCause().getMessage() != null ? e.getCause().getMessage() : "");
        }

        return strBuilder.toString() ;
    }
    
}
