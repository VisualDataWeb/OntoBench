package de.linkvt.bachelor.features.classes;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.springframework.stereotype.Component;

@Component
public class OwlOneOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLNamedIndividual black = factory.getOWLNamedIndividual(IRI.create("Black"));
    OWLNamedIndividual white = factory.getOWLNamedIndividual(IRI.create("White"));
    OWLObjectOneOf oneOf = factory.getOWLObjectOneOf(black, white);

    OWLClass oneOfClass = factory.getOWLClass(IRI.create("BlackOrWhite"));

    OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(oneOfClass, oneOf);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:oneOf";
  }

  @Override
  public String getToken() {
    return "oneof";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS;
  }
}
