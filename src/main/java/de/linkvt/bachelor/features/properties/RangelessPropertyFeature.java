package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Property without a range.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class RangelessPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getExclusiveClass("Domain");
    OWLObjectProperty objectProperty = featurePool.getExclusiveProperty("HasNoRange");
    OWLAxiom axiom = factory.getOWLObjectPropertyDomainAxiom(objectProperty, domain);

    addToOntology(ontology, axiom);
  }
}
