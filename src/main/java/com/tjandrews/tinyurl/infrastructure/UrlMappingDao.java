package com.tjandrews.tinyurl.infrastructure;

import java.util.Optional;

import com.tjandrews.tinyurl.infrastructure.models.UrlMapping;

public interface UrlMappingDao {
  
  UrlMapping create(UrlMapping urlMapping);
  void update(UrlMapping urlMapping);
  Optional<UrlMapping> getById(Integer id);
  Optional<UrlMapping> getByEncodedValue(String encodedValue);
  
}
