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
  private static final String GENERIC_NAME = "Generic";
  Set<OWLClass> classPool = new HashSet<>();
  private Integer genericCounter = 0;
  private OWLDataFactory factory;

  public FeaturePool(OWLDataFactory factory) {
    this.factory = factory;
  }

  public OWLClass getReusableClass() {
    OWLClass owlClass;
    if (classPool.isEmpty()) {
      owlClass = getExclusiveClass(createGenericName());
      classPool.add(owlClass);
    } else {
      owlClass = classPool.iterator().next();
    }
    return owlClass;
  }

  private String createGenericName() {
    return GENERIC_NAME + ++genericCounter;
  }

  public OWLClass getExclusiveClass(String name) {
    return factory.getOWLClass(IRI.create(name));
  }

}
