package com.tjandrews.tinyurl.presentation.exceptions;

public class UrlMappingNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public UrlMappingNotFoundException(Integer id) {
    super("Could not find URL mapping for id " + id);
  }  
}
