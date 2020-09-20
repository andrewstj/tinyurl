package com.tjandrews.tinyurl.presentation.exceptions;

import java.net.MalformedURLException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidUrlAdvice {
  @ResponseBody
  @ExceptionHandler(MalformedURLException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  String malformedUrlHandler(MalformedURLException ex) {
    return ex.getMessage();
  }
}
