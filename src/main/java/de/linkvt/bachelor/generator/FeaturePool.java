package de.linkvt.bachelor.generator;

import de.linkvt.bachelor.generator.pools.ClassPool;
import de.linkvt.bachelor.generator.pools.PropertyPool;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Encapsulates different more specific resource pools.
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class FeaturePool {
  private ClassPool classPool;
  private PropertyPool propertyPool;

  @Autowired
  public FeaturePool(ClassPool classPool, PropertyPool propertyPool) {
    this.classPool = classPool;
    this.propertyPool = propertyPool;
  }

  public OWLClass getReusableClass() {
    return classPool.getReusableObject();
  }

  public OWLClass getReusableClass(String preferredIri) {
    return classPool.getReusableObject(preferredIri);
  }

  public OWLClass getReusableClassDifferentFrom(OWLClass... differentFrom) {
    return classPool.getResuableObjectDifferentFrom(new HashSet<>(Arrays.asList(differentFrom)));
  }

  public OWLClass getReusableClassAndRemoveFromPool() {
    return classPool.getReusableObjectAndRemoveFromPool();
  }

  public OWLClass getExclusiveClass(String name) {
    return classPool.getExclusiveObject(name);
  }

  public OWLObjectProperty getReusableProperty() {
    return propertyPool.getReusableObject();
  }

  public OWLObjectProperty getReusableProperty(String preferredIri) {
    return propertyPool.getReusableObject(preferredIri);
  }

  public OWLObjectProperty getReusablePropertyAndRemoveFromPool() {
    return propertyPool.getReusableObjectAndRemoveFromPool();
  }

  public OWLObjectProperty getExclusiveProperty(String name) {
    return propertyPool.getExclusiveObject(name);
  }

}
