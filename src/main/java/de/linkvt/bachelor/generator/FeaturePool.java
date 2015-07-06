package de.linkvt.bachelor.generator;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class FeaturePool {
  Set<OWLClass> classPool = new HashSet<>();
  private OWLDataFactory factory;

  public FeaturePool(OWLDataFactory factory) {
    this.factory = factory;
  }

  public OWLClass getReusableClass(String name) {
    OWLClass owlClass;
    if (classPool.isEmpty()) {
      owlClass = getNewClass(name);
      classPool.add(owlClass);
    } else {
      owlClass = classPool.iterator().next();
    }
    return owlClass;
  }

  public OWLClass getNewClass(String name) {
    return factory.getOWLClass(IRI.create(name));
  }

  public OWLDataFactory getFactory() {
    return factory;
  }
}
