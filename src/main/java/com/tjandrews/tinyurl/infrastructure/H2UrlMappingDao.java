package com.tjandrews.tinyurl.infrastructure;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tjandrews.tinyurl.infrastructure.models.UrlMapping;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class H2UrlMappingDao implements UrlMappingDao {
  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  @Override
  public Integer create(UrlMapping urlMapping) {
    entityManager.persist(urlMapping);
    entityManager.flush();
    return urlMapping.getId();
  }

  @Override
  public UrlMapping getById(Integer id) {
    entityManager.find(UrlMapping.class, id);
    return null;
  }

  @Override
  public UrlMapping getByEncodedValue(String encodedValue) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
