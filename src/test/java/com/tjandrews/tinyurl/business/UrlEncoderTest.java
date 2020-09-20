package com.tjandrews.tinyurl.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UrlEncoderTest {
  
  @Test
  public void decodeUrlToId_validUrls_decodesToId() {
    // arrange
    Map<String, Integer> givenUrlExpectedIdMap = new HashMap<String, Integer>();
    givenUrlExpectedIdMap.put("a8VeF", 459204116);
    givenUrlExpectedIdMap.put("AR4BJ", 523824572);
    givenUrlExpectedIdMap.put("AQXZ", 12345714);
    givenUrlExpectedIdMap.put("b", 1);
    

    // act
    givenUrlExpectedIdMap.forEach((givenUrl, expectedId) -> {
      Integer actual = UrlEncoder.decodeUrlToId(givenUrl);
      // assert
      assertEquals(expectedId, actual);
    });
  }

  @Test
  public void encodeIdToUrl_validIds_encodesToUrl() {
    // arrange
    Map<Integer, String> givenIdExpectedUrlMap = new HashMap<Integer, String>();
    givenIdExpectedUrlMap.put(459204116, "a8VeF");
    givenIdExpectedUrlMap.put(523824572, "AR4BJ");
    givenIdExpectedUrlMap.put(12345714, "AQXZ");
    givenIdExpectedUrlMap.put(1, "b");
    

    // act
    givenIdExpectedUrlMap.forEach((givenId, expectedUrl) -> {
      String actual = UrlEncoder.encodeIdToUrl(givenId);
      // assert
      assertEquals(expectedUrl, actual);
    });
  }

  @Test
  public void decodeUrlToId_invalidUrlCharacter_throws() {
    // arrange
    String[] badSymbols = "!@#$%^&*()_-+=:;~`?/.,<>".split("");
    
    // act / assert
    for (String badSymbol : badSymbols) {
      assertThrows(RuntimeException.class, () -> UrlEncoder.decodeUrlToId(badSymbol), "Expected runtime exception");
    }
    
  }
}
