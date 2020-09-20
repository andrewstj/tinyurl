package com.tjandrews.tinyurl.business;

public class UrlEncoder {
  private static final char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
  private static final int charsLength = chars.length;

  public static String encodeIdToUrl(Integer id) {
    StringBuffer compressedUrl = new StringBuffer();
    int tempId = id.intValue();
    while (tempId > 0) {
      compressedUrl.append(chars[tempId % charsLength]);
      tempId /= charsLength;
    }
    return compressedUrl.toString();
  }

  public static Integer decodeUrlToId(String url) {
    int id = 0;
    char[] urlChars = url.toCharArray();
    for (int i = urlChars.length - 1; i >= 0; i--) {
      if ('a' <= urlChars[i] && urlChars[i] <= 'z') {
        id = id * charsLength + urlChars[i] - 'a';
      } else if ('A' <= urlChars[i] && urlChars[i] <= 'Z') {
        id = id * charsLength + urlChars[i] - 'A' + 26;
      } else if ('0' <= urlChars[i] && urlChars[i] <= '9') {
        id = id * charsLength + urlChars[i] - '0' + 52;
      } else {
        throw new RuntimeException("Unknown character " + urlChars[i]);
      }
    }
    return Integer.valueOf(id);
  }
}
