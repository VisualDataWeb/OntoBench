package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Property without a domain.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class DomainlessPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass range = featurePool.getExclusiveClass("Range");
    OWLObjectProperty objectProperty = featurePool.getExclusiveProperty("HasNoDomain");
    OWLAxiom axiom = factory.getOWLObjectPropertyRangeAxiom(objectProperty, range);

    addToOntology(ontology, axiom);
  }
}
