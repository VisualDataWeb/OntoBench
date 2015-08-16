package de.linkvt.bachelor.features.assertions;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.springframework.stereotype.Component;

@Component
public class OwlAllDifferentFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLNamedIndividual donGiovanni = factory.getOWLNamedIndividual(":Don_Giovanni", pm);
    OWLNamedIndividual tosca = factory.getOWLNamedIndividual(":Tosca", pm);
    OWLNamedIndividual salome = factory.getOWLNamedIndividual(":Salome", pm);
    OWLNamedIndividual nozzeDiFigaro = factory.getOWLNamedIndividual(":Nozze_di_Figaro", pm);

    addAxiomToOntology(factory.getOWLDifferentIndividualsAxiom(donGiovanni, tosca, salome, nozzeDiFigaro));
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
