package de.linkvt.bachelor.persistence;

import org.springframework.data.repository.CrudRepository;

/**
 * Repository for accessing a stored feature.
 */
public interface StoredFeatureRepository extends CrudRepository<StoredFeature, Long> {

  StoredFeature findByToken(String token);

}
