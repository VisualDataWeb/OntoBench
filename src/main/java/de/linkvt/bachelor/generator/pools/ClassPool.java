package de.linkvt.bachelor.generator.pools;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;

/**
 * An owl class resource pool.
 */
public class ClassPool extends ResourcePool<OWLClass> {
  public ClassPool(OWLDataFactory factory) {
    super(factory);
  }

  @Override
  public OWLClass getExclusiveObject(String name) {
    return factory.getOWLClass(IRI.create(name));
  }

  @Override
  protected String getGenericNameBase() {
    return "Class";
  }
}
