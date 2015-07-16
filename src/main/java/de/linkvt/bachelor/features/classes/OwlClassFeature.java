package de.linkvt.bachelor.features.classes;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

/**
 * An owl class.
 */
@Component
public class OwlClassFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass owlClass = featurePool.getReusableClass();
    OWLAxiom axiom = factory.getOWLDeclarationAxiom(owlClass);

    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:Class";
  }

  @Override
  public String getToken() {
    return "owlclass";
  }

  @Override
  public boolean isGeneral() {
    return true;
  }
}
