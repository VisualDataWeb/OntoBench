package de.linkvt.bachelor.features.classexpressions.connectivesandenumeration;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectIntersectionOfOwl2QlFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass fork = featurePool.getExclusiveClass(":Fork");
    OWLClass spoon = featurePool.getExclusiveClass(":Spoon");
    OWLObjectIntersectionOf spork = factory.getOWLObjectIntersectionOf(fork, spoon);

    OWLClass owlClass = featurePool.getExclusiveClass(":Spork");

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(owlClass, spork));
  }

  @Override
  public String getName() {
    return "owl:intersectionOf (Class, OWL 2 QL)";
  }

  @Override
  public String getToken() {
    return "intersectionofqlclass";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CONNECTIVES_AND_ENUMERATION;
  }
}
