package de.linkvt.bachelor.features.classes;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

/**
 * The owl nothing.
 */
@Component
public class OwlNothingFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass owlNothing = factory.getOWLNothing();
    OWLAxiom axiom = factory.getOWLDeclarationAxiom(owlNothing);

    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:Nothing";
  }

  @Override
  public String getToken() {
    return "owlnothing";
  }
}
