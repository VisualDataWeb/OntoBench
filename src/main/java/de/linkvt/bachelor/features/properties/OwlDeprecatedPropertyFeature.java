package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;

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
public class OwlDeprecatedPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getReusablePropertyAndRemoveFromPool();

    OWLAnnotation annotation = factory.getOWLAnnotation(factory.getOWLDeprecated(), factory.getOWLLiteral(true));
    OWLAxiom deprecatedAxiom = factory.getOWLAnnotationAssertionAxiom(property.getIRI(), annotation);

    OWLAxiom axiom = factory.getOWLDeclarationAxiom(property);

    addToOntology(ontology, deprecatedAxiom);
    addToOntology(ontology, axiom);
  }
}
