package de.linkvt.bachelor.generator.pools;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectProperty;

/**
 * An owl object property pool.
 */
public class PropertyPool extends ResourcePool<OWLObjectProperty> {
  public PropertyPool(OWLDataFactory factory) {
    super(factory);
  }

  @Override
  public OWLObjectProperty getExclusiveObject(String name) {
    return factory.getOWLObjectProperty(IRI.create(name));
  }

  @Override
  protected String getGenericNameBase() {
    return "Property";
  }

}
