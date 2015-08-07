package de.linkvt.bachelor.features.individuals;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.springframework.stereotype.Component;

@Component
public class NamedIndividualFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLNamedIndividual namedIndividual = factory.getOWLNamedIndividual(IRI.create("NamedIndividual"));
    OWLAxiom axiom = factory.getOWLDeclarationAxiom(namedIndividual);

    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "Named Individual";
  }

  @Override
  public String getToken() {
    return "namedindividual";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.INDIVIDUAL;
  }
}
