package de.linkvt.bachelor.features.individuals.assertions;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.springframework.stereotype.Component;

@Component
public class OwlAllDifferentFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLNamedIndividual i1 = factory.getOWLNamedIndividual(":AllDifferent_Individual1", pm);
    OWLNamedIndividual i2 = factory.getOWLNamedIndividual(":AllDifferent_Individual2", pm);
    OWLNamedIndividual i3 = factory.getOWLNamedIndividual(":AllDifferent_Individual3", pm);
    OWLNamedIndividual i4 = factory.getOWLNamedIndividual(":AllDifferent_Individual4", pm);

    addAxiomToOntology(factory.getOWLDifferentIndividualsAxiom(i1, i2, i3, i4));
  }

  @Override
  public String getName() {
    return "owl:AllDifferent";
  }

  @Override
  public String getToken() {
    return "alldifferent";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ASSERTIONS;
  }
}
