package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * An owl object property.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class OwlObjectPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getReusableClass();
    OWLClass range = featurePool.getExclusiveClass("ObjectPropertyRange");
    OWLObjectProperty objectProperty = featurePool.getExclusiveProperty("ObjectProperty");

    OWLAxiom domainAxiom = factory.getOWLObjectPropertyDomainAxiom(objectProperty, domain);
    OWLAxiom rangeAxiom = factory.getOWLObjectPropertyRangeAxiom(objectProperty, range);

    addToOntology(ontology, domainAxiom);
    addToOntology(ontology, rangeAxiom);
  }
}
