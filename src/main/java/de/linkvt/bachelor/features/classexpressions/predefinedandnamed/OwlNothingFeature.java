package de.linkvt.bachelor.features.classexpressions.predefinedandnamed;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

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
    return "nothing";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.PREDEFINED_CLASSES;
  }
}
