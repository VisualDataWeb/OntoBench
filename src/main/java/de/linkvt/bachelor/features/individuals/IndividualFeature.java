package de.linkvt.bachelor.features.individuals;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public class IndividualFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass individual = factory.getOWLClass(IRI.create("Individual"));
    OWLAxiom axiom = factory.getOWLDeclarationAxiom(individual);

    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "Individual";
  }

  @Override
  public String getToken() {
    return "individual";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.INDIVIDUAL;
  }
}
