package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.web.converters.parameter.ParameterName;

import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * An owl deprecated property.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
@ParameterName("deprecatedprop")
public class OwlDeprecatedPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty("DeprecatedProperty");
    addToGenericDomainAndNewRange(property, featurePool.getExclusiveClass("DeprecatedPropertyRange"));

    OWLAnnotation annotation = factory.getOWLAnnotation(factory.getOWLDeprecated(), factory.getOWLLiteral(true));
    OWLAxiom deprecatedAxiom = factory.getOWLAnnotationAssertionAxiom(property.getIRI(), annotation);
    addAxiomToOntology(deprecatedAxiom);
  }
}
