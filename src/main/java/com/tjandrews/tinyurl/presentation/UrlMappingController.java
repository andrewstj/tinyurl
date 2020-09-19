package com.tjandrews.tinyurl.presentation;

import com.tjandrews.tinyurl.business.UrlMappingService;
import com.tjandrews.tinyurl.business.models.UrlMappingRequest;
import com.tjandrews.tinyurl.infrastructure.models.UrlMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class UrlMappingController {
  private final UrlMappingService urlMappingService;

  @PostMapping(path="/urlMapping")
  public UrlMapping createMappingForUrl(@RequestBody UrlMappingRequest urlMapping) {
    return urlMappingService.createUrlMapping(urlMapping);
  }
}
