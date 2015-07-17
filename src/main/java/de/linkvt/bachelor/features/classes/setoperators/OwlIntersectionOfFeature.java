package de.linkvt.bachelor.features.classes.setoperators;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.springframework.stereotype.Component;

/**
 * An owl intersectionOf feature.
 */
@Component
public class OwlIntersectionOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass fork = featurePool.getExclusiveClass("Fork");
    OWLClass spoon = featurePool.getExclusiveClass("Spoon");
    OWLObjectIntersectionOf spork = factory.getOWLObjectIntersectionOf(fork, spoon);

    OWLClass owlClass = factory.getOWLClass(IRI.create("Spork"));

    OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(owlClass, spork);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:intersectionOf";
  }

  @Override
  public String getToken() {
    return "intersection";
  }
}
