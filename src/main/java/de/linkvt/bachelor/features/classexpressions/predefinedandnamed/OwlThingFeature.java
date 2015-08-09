package de.linkvt.bachelor.features.classexpressions.predefinedandnamed;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

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

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.PREDEFINED_CLASSES;
  }
}
