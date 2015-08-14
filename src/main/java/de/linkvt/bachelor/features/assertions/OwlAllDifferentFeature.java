package de.linkvt.bachelor.features.assertions;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.springframework.stereotype.Component;

@Component
public class OwlAllDifferentFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLNamedIndividual donGiovanni = factory.getOWLNamedIndividual(IRI.create(":Don_Giovanni"));
    OWLNamedIndividual tosca = factory.getOWLNamedIndividual(IRI.create(":Tosca"));
    OWLNamedIndividual salome = factory.getOWLNamedIndividual(IRI.create(":Salome"));
    OWLNamedIndividual nozzeDiFigaro = factory.getOWLNamedIndividual(IRI.create(":Nozze_di_Figaro"));

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
