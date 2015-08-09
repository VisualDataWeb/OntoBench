package de.linkvt.bachelor.features.assertions;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.springframework.stereotype.Component;

@Component
public class OwlSameAsFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLNamedIndividual williamClinton = factory.getOWLNamedIndividual(IRI.create("William_Jefferson_Clinton"));
    OWLNamedIndividual billClinton = factory.getOWLNamedIndividual(IRI.create("BillClinton"));

    addAxiomToOntology(factory.getOWLSameIndividualAxiom(williamClinton, billClinton));
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
