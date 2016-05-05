package de.linkvt.ontobench.features.individuals.assertions;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.springframework.stereotype.Component;

@Component
public class OwlSameAsFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLNamedIndividual i1 = factory.getOWLNamedIndividual(":SameAs_Individual1", pm);
    OWLNamedIndividual i2 = factory.getOWLNamedIndividual(":SameAs_Individual2", pm);

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
