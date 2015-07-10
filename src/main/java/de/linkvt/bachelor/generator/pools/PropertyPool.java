package de.linkvt.bachelor.generator.pools;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * An owl object property pool.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PropertyPool extends ResourcePool<OWLObjectProperty> {
  @Autowired
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
