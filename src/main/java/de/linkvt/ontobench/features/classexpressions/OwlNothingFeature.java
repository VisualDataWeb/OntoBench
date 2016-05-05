package de.linkvt.ontobench.features.classexpressions;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

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
    return FeatureCategory.CLASS_EXPRESSIONS;
  }
}
