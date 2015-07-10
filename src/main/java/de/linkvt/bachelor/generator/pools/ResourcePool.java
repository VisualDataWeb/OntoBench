package de.linkvt.bachelor.generator.pools;

import org.semanticweb.owlapi.model.OWLDataFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * A generic resource pool.
 */
public abstract class ResourcePool<T> {
  protected OWLDataFactory factory;
  private Set<T> objectPool = new HashSet<>();
  private Integer genericCounter = 0;

  public ResourcePool(OWLDataFactory factory) {
    this.factory = factory;
  }

  /**
   * Returns if available an object from the pool or a new one if none is available. The new object
   * will receive a generic iri.
   *
   * @return an object from the pool or if not available a new one with a generic name
   */
  public T getReusableObject() {
    return getReusableObject(createGenericName());
  }

  /**
   * Returns if available an object from the pool or a new one if none is available. The new object
   * will receive the passed iri.
   *
   * @param preferredIri the iri of a new object, if one has to be created
   * @return an object from the pool or if not available a new one
   */
  public T getReusableObject(String preferredIri) {
    T object;
    if (objectPool.isEmpty()) {
      object = getExclusiveObject(preferredIri);
      objectPool.add(object);
    } else {
      object = objectPool.iterator().next();
    }
    return object;
  }

  public T getReusableObjectAndRemoveFromPool() {
    T object = getReusableObject();
    removeFromPool(object);
    return object;
  }

  private String createGenericName() {
    return getGenericNameBase() + increaseGenericObjectCount();
  }

  protected String getGenericNameBase() {
    return "Generic";
  }

  protected int increaseGenericObjectCount() {
    return ++genericCounter;
  }

  /**
   * Removes the passed object from the pool so it can't be used for other purposes.
   *
   * @param object the object that should be removed
   * @return true, if removing was successful
   */
  public boolean removeFromPool(T object) {
    return objectPool.remove(object);
  }

  public abstract T getExclusiveObject(String name);

}
