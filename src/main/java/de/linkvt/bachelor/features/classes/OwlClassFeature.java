package de.linkvt.bachelor.features.classes;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * An owl class.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class OwlClassFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass owlClass = featurePool.getReusableClass();
    OWLAxiom axiom = factory.getOWLDeclarationAxiom(owlClass);

    addToOntology(ontology, axiom);
  }
}
