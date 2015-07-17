package de.linkvt.bachelor.features.classes;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.springframework.stereotype.Component;

/**
 * An owl oneOf feature.
 */
@Component
public class OwlUnionOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass fork = featurePool.getExclusiveClass("Fork");
    OWLClass knife = featurePool.getExclusiveClass("Knife");
    OWLClass spoon = featurePool.getExclusiveClass("Spoon");
    OWLObjectUnionOf cutlery = factory.getOWLObjectUnionOf(fork, knife, spoon);

    OWLClass oneOfClass = factory.getOWLClass(IRI.create("Cutlery"));

    OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(oneOfClass, cutlery);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:unionOf";
  }

  @Override
  public String getToken() {
    return "owlunionof";
  }
}
