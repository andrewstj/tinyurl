package com.tjandrews.tinyurl.infrastructure;

import com.tjandrews.tinyurl.infrastructure.models.UrlMapping;

public interface UrlMappingDao {
  
  UrlMapping create(UrlMapping urlMapping);
  void update(UrlMapping urlMapping);
  UrlMapping getById(Integer id);
  UrlMapping getByEncodedValue(String encodedValue);
  
}
