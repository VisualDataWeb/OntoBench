package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

/**
 * An owl symmetric property.
 */
@Component
public class OwlSymmetricPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getReusablePropertyAndRemoveFromPool();
    OWLClass range = featurePool.getExclusiveClass("SymmetricPropertyRange");
    addToGenericDomainAndNewRange(property, range);

    OWLAxiom axiom = factory.getOWLSymmetricObjectPropertyAxiom(property);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:SymmetricProperty";
  }

  @Override
  public String getToken() {
    return "symmetricprop";
  }
}
