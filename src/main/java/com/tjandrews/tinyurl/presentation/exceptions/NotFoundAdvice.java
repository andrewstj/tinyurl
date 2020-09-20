package com.tjandrews.tinyurl.presentation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundAdvice {
  @ResponseBody
  @ExceptionHandler(EncodedPathNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String encodedPathNotFoundHandler(EncodedPathNotFoundException ex) {
    return ex.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(UrlMappingNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String urlMappingNotFoundHandler(UrlMappingNotFoundException ex) {
    return ex.getMessage();
  }
  
}
