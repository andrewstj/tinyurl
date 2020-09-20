package com.tjandrews.tinyurl.presentation;

import java.net.URI;

import com.tjandrews.tinyurl.business.UrlMappingService;
import com.tjandrews.tinyurl.business.models.UrlMappingRequest;
import com.tjandrews.tinyurl.business.models.UrlMappingResponse;
import com.tjandrews.tinyurl.infrastructure.models.UrlMapping;
import com.tjandrews.tinyurl.presentation.exceptions.EncodedPathNotFoundException;
import com.tjandrews.tinyurl.presentation.exceptions.UrlMappingNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class UrlMappingController {
  private final UrlMappingService urlMappingService;

  @PostMapping(path = "/urlMapping")
  public UrlMappingResponse createMappingForUrl(@RequestBody UrlMappingRequest request) {
    // TODO: Add validator for url string
    // https://www.geeksforgeeks.org/check-if-url-is-valid-or-not-in-java/#:~:text=url%20class%20to%20validate%20a,Else%20we%20return%20false.
    UrlMapping urlMapping = urlMappingService.createUrlMapping(request);
    String encodedUrl = urlMappingService.getEncodedUrl(urlMapping);
    return new UrlMappingResponse(request.getUrl(), encodedUrl);
  }

  @GetMapping(path = "/urlMapping/{id}")
  public UrlMapping getMappingFromId(@PathVariable final Integer id) {
    return urlMappingService.getById(id).orElseThrow(() -> new UrlMappingNotFoundException(id));
  }

  @GetMapping(path = UrlMappingService.pathPrefix + "{encodedPath}")
  public ResponseEntity<Object> redirectToUrl(@PathVariable final String encodedPath) {
    return urlMappingService.getUrlFromEncodedValue(encodedPath).map(redirectUrl -> {
      HttpHeaders headers = new HttpHeaders();
      headers.setLocation(URI.create(redirectUrl));
      return new ResponseEntity<>(headers, HttpStatus.TEMPORARY_REDIRECT);
    }).orElseThrow(() -> new EncodedPathNotFoundException(encodedPath));
  }

}
