package de.linkvt.bachelor.generator.pools;

import org.semanticweb.owlapi.model.OWLDataFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * A generic resource pool.
 */
public abstract class ResourcePool<T> {
  private static final String GENERIC_NAME = "Generic";
  protected OWLDataFactory factory;
  Set<T> objectPool = new HashSet<>();
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
    return GENERIC_NAME + ++genericCounter;
  }

  public abstract T getExclusiveObject(String name);

}
