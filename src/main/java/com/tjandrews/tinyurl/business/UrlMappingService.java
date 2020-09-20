package com.tjandrews.tinyurl.business;

import com.tjandrews.tinyurl.business.models.UrlMappingRequest;
import com.tjandrews.tinyurl.infrastructure.UrlMappingDao;
import com.tjandrews.tinyurl.infrastructure.models.UrlMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UrlMappingService {

  @Autowired
  private final UrlMappingDao urlMappingDao;

  public UrlMapping createUrlMapping(UrlMappingRequest mappingRequest) {
    UrlMapping urlMapping = new UrlMapping();
    urlMapping.setUrl(mappingRequest.getUrl());
    urlMappingDao.create(urlMapping);
    urlMapping.setEncodedValue(UrlEncoder.encodeIdToUrl(urlMapping.getId()));
    urlMappingDao.update(urlMapping);
    return urlMapping;
  };

  public UrlMapping getById(Integer id) {
    return urlMappingDao.getById(id);
  }
  
}
