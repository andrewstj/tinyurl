package com.tjandrews.tinyurl.presentation.exceptions;

public class EncodedPathNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public EncodedPathNotFoundException(String encodedValue) {
    super("Could not find URL for encoded value " + encodedValue);
  }  
}