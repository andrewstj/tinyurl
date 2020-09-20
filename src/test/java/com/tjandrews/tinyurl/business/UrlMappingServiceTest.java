package com.tjandrews.tinyurl.business;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UrlMappingServiceTest {
  @Test
  public void isValidUrl_validUrls_true() {
    // arrange
    String[] givenUrls = { "http://something.com", "https://a.net", "http://www.b.biz", "https://c:8080", "ftp://abc.com" };
    
    // act / assert
    for (String givenUrl : givenUrls) {
      assertTrue(UrlMappingService.isValidUrl(givenUrl), "Expected to be valid: " + givenUrl);
    }
  }

  @Test
  public void isValidUrl_invalidUrls_false() {
    // arrange
    String[] givenUrls = { "abc", "www.b.com", "ws://a.com" };
    
    // act / assert
    for (String givenUrl : givenUrls) {
      assertFalse(UrlMappingService.isValidUrl(givenUrl), "Expected to be invalid: " + givenUrl);
    }
  }

}
