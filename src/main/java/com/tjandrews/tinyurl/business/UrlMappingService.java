package com.tjandrews.tinyurl.business;

import java.util.Optional;

import com.tjandrews.tinyurl.business.models.UrlMappingRequest;
import com.tjandrews.tinyurl.infrastructure.UrlMappingDao;
import com.tjandrews.tinyurl.infrastructure.models.UrlMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrlMappingService {
  // TODO: Make this an external config property
  private static final String baseUrl = "http://localhost:8080";
  public static final String pathPrefix = "/r/";

  @Autowired
  private final UrlMappingDao urlMappingDao;

  public String getEncodedUrl(UrlMapping urlMapping) {
    return baseUrl + pathPrefix + urlMapping.getEncodedValue();
  }

  public UrlMapping createUrlMapping(UrlMappingRequest mappingRequest) {
    UrlMapping urlMapping = new UrlMapping();
    urlMapping.setUrl(mappingRequest.getUrl());
    urlMappingDao.create(urlMapping);
    urlMapping.setEncodedValue(UrlEncoder.encodeIdToUrl(urlMapping.getId()));
    urlMappingDao.update(urlMapping);
    return urlMapping;
  };

  public Optional<UrlMapping> getById(Integer id) {
    return urlMappingDao.getById(id);
  }

  public Optional<String> getUrlFromEncodedValue(String encodedValue) {
    return urlMappingDao.getByEncodedValue(encodedValue).map(UrlMapping::getUrl);
  }

}
