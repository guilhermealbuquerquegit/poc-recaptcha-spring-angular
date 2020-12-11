package com.mobitbrasil.apirecaptcha.recaptcha.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BadRequestException;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity badRequest(BadRequestException exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(HttpStatus.BAD_REQUEST.value(), exception.getMessage()));
    }

}
