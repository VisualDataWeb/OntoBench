package de.linkvt.bachelor.generator;

import de.linkvt.bachelor.generator.pools.ClassPool;
import de.linkvt.bachelor.generator.pools.PropertyPool;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectProperty;

/**
 * Encapsulates different more specific resource pools.
 */
public class FeaturePool {
  private final ClassPool classPool;
  private final PropertyPool propertyPool;

  public FeaturePool(OWLDataFactory factory) {
    classPool = new ClassPool(factory);
    propertyPool = new PropertyPool(factory);
  }

  public OWLClass getReusableClass() {
    return classPool.getReusableObject();
  }

  public OWLClass getExclusiveClass(String name) {
    return classPool.getExclusiveObject(name);
  }

  public OWLObjectProperty getReusableProperty() {
    return propertyPool.getReusableObject();
  }

  public OWLObjectProperty getReusablePropertyAndRemoveFromPool() {
    return propertyPool.getReusableObjectAndRemoveFromPool();
  }

  public OWLObjectProperty getExclusiveProperty(String name) {
    return propertyPool.getExclusiveObject(name);
  }

}
