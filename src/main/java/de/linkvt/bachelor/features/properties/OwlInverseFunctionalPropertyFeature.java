package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * An owl functional property.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class OwlInverseFunctionalPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getReusablePropertyAndRemoveFromPool();
    OWLClass range = featurePool.getExclusiveClass("InverseFunctionalPropertyRange");
    addToGenericDomainAndNewRange(property, range);

    OWLAxiom axiom = factory.getOWLInverseFunctionalObjectPropertyAxiom(property);
    addAxiomToOntology(axiom);
  }
}
