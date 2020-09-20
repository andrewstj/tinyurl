package com.tjandrews.tinyurl.infrastructure;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.tjandrews.tinyurl.infrastructure.models.UrlMapping;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JpaUrlMappingDao implements UrlMappingDao {
  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  @Override
  public UrlMapping create(UrlMapping urlMapping) {
    entityManager.persist(urlMapping);
    entityManager.flush();
    return urlMapping;
  }

  @Transactional
  @Override
  public void update(UrlMapping urlMapping) {
    entityManager.merge(urlMapping);
    entityManager.flush();
  }

  @Override
  public Optional<UrlMapping> getById(Integer id) {
    return Optional.ofNullable(entityManager.find(UrlMapping.class, id));
  }

  @Override
  public Optional<UrlMapping> getByEncodedValue(String encodedValue) {
    try {
      TypedQuery<UrlMapping> getByEncodedValue = entityManager
          .createQuery("from UrlMapping WHERE encodedValue = :encodedValue", UrlMapping.class);
      UrlMapping mapping = getByEncodedValue.setParameter("encodedValue", encodedValue).getSingleResult();
      return Optional.of(mapping);
    } catch (NoResultException exception) {
      return Optional.empty();
    }
  }

}
