package de.linkvt.bachelor.generator.pools;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * An owl class resource pool.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ClassPool extends ResourcePool<OWLClass> {
  private static final int MAX_REUSES = 16;

  @Autowired
  public ClassPool(OWLDataFactory factory) {
    super(factory, MAX_REUSES);
  }

  @Override
  public OWLClass getExclusiveObject(String name) {
    return factory.getOWLClass(IRI.create(name));
  }

  @Override
  protected String getGenericNameBase() {
    return ":Class";
  }
}
