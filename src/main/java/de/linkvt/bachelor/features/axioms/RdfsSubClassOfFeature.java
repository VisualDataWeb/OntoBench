package de.linkvt.bachelor.features.axioms;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * The rdfs:subClassOf axiom.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class RdfsSubClassOfFeature extends Feature {

  @Override
  public void addToOntology() {
    OWLClass superClass = featurePool.getExclusiveClass("SuperClass");
    OWLClass subClass = featurePool.getExclusiveClass("SubClass");
    OWLAxiom subClassOfAxiom = factory.getOWLSubClassOfAxiom(subClass, superClass);

    addAxiomToOntology(subClassOfAxiom);
  }
}
