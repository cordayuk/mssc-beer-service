package com.example.msscbeerservice.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MvcExceptionHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<List<String>> validationErrorHandler( ConstraintViolationException ex)
  {
    final List<String> errorlist = new ArrayList<>(ex.getConstraintViolations().size());

    ex.getConstraintViolations().forEach( error -> errorlist.add(error.toString()));

    return new ResponseEntity<>(errorlist, HttpStatus.BAD_REQUEST);
  }
}
