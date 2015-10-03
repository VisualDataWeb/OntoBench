package de.linkvt.bachelor.features.assertions;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.springframework.stereotype.Component;

@Component
public class OwlSameAsFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLNamedIndividual i1 = factory.getOWLNamedIndividual(":SameAs_1", pm);
    OWLNamedIndividual i2 = factory.getOWLNamedIndividual(":SameAs_2", pm);

    addAxiomToOntology(factory.getOWLSameIndividualAxiom(i1, i2));
  }

  @Override
  public String getName() {
    return "owl:sameAs";
  }

  @Override
  public String getToken() {
    return "sameas";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ASSERTIONS;
  }
}
