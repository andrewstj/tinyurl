package com.tjandrews.tinyurl.business.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UrlMappingResponse { 
  private final String url;
  private final String encodedUrl;
}
