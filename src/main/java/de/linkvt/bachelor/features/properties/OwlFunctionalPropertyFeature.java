package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * An owl functional property.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class OwlFunctionalPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getReusablePropertyAndRemoveFromPool();

    OWLAxiom axiom = factory.getOWLFunctionalObjectPropertyAxiom(property);

    addAxiomToOntology(axiom);
  }
}