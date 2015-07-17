package de.linkvt.bachelor.features.classes;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

/**
 * The owl thing.
 */
@Component
public class OwlThingFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass owlThing = factory.getOWLThing();
    OWLAxiom axiom = factory.getOWLDeclarationAxiom(owlThing);

    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:Thing";
  }

  @Override
  public String getToken() {
    return "thing";
  }
}
