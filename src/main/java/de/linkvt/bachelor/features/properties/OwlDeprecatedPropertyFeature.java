package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

/**
 * An owl deprecated property.
 */
@Component
public class OwlDeprecatedPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty("DeprecatedProperty");
    addToGenericDomainAndNewRange(property, featurePool.getExclusiveClass("DeprecatedPropertyRange"));

    OWLAnnotation annotation = factory.getOWLAnnotation(factory.getOWLDeprecated(), factory.getOWLLiteral(true));
    OWLAxiom deprecatedAxiom = factory.getOWLAnnotationAssertionAxiom(property.getIRI(), annotation);
    addAxiomToOntology(deprecatedAxiom);
  }

  @Override
  public String getName() {
    return "owl:DeprecatedProperty";
  }

  @Override
  public String getToken() {
    return "deprecatedprop";
  }
}
