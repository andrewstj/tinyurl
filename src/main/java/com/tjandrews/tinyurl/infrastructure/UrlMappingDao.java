package com.tjandrews.tinyurl.infrastructure;

import com.tjandrews.tinyurl.infrastructure.models.UrlMapping;

public interface UrlMappingDao {
  
  Integer create(UrlMapping urlMapping);
  UrlMapping getById(Integer id);
  UrlMapping getByEncodedValue(String encodedValue);
  
}
