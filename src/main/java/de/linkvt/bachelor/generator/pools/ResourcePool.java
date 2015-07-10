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

  public T getReusableObject() {
    T object;
    if (objectPool.isEmpty()) {
      object = getExclusiveObject(createGenericName());
      objectPool.add(object);
    } else {
      object = objectPool.iterator().next();
    }
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
