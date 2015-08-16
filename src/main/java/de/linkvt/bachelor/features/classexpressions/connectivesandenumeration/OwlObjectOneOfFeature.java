package de.linkvt.bachelor.features.classexpressions.connectivesandenumeration;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectOneOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLNamedIndividual black = factory.getOWLNamedIndividual(":Black", pm);
    OWLNamedIndividual white = factory.getOWLNamedIndividual(":White", pm);
    OWLObjectOneOf oneOf = factory.getOWLObjectOneOf(black, white);

    OWLClass oneOfClass = featurePool.getExclusiveClass(":BlackOrWhite");

    OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(oneOfClass, oneOf);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:oneOf (Class)";
  }

  @Override
  public String getToken() {
    return "oneofclass";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CONNECTIVES_AND_ENUMERATION;
  }
}
