package com.infosys.cutomer_service.exceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomisedExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(CustomerNotFoundException.class)
  public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(CustomerNotFoundException ex,WebRequest request) {
   ExceptionResponse errorDetails = new ExceptionResponse(HttpStatus.NOT_FOUND.value(),new Date(), ex.getMessage(),
        request.getDescription(false));
   //ResponseEntity<> responseEntity= new Re
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(CustomerAlreadyExistException.class)
  public final ResponseEntity<ExceptionResponse> handleUserAlreadyExistException(CustomerAlreadyExistException ex,WebRequest request) {
   ExceptionResponse errorDetails = new ExceptionResponse(HttpStatus.CONFLICT.value(),new Date(), ex.getMessage(),
        request.getDescription(false));
   //ResponseEntity<> responseEntity= new Re
    return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
  }
  
  @Override
  protected ResponseEntity<Object>
  handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                               HttpHeaders headers,
                               HttpStatus status, WebRequest request) {

      Map<String, Object> body = new LinkedHashMap<>();
      body.put("timestamp", new Date());
      body.put("status", status.value());

      //Get all fields errors
      List<String> errors = ex.getBindingResult()
              .getFieldErrors()
              .stream()
              .map(x -> x.getDefaultMessage())
              .collect(Collectors.toList());

      body.put("errors", errors);

      return new ResponseEntity<>(body, headers, status);

  }
 
 
  
  
}