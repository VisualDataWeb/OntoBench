package de.linkvt.bachelor.features.classexpressions.connectivesandenumeration;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectIntersectionOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass fork = featurePool.getExclusiveClass(":Fork");
    OWLClass spoon = featurePool.getExclusiveClass(":Spoon");
    OWLObjectIntersectionOf spork = factory.getOWLObjectIntersectionOf(fork, spoon);

    OWLClass owlClass = factory.getOWLClass(IRI.create(":Spork"));

    OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(owlClass, spork);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:intersectionOf (Class)";
  }

  @Override
  public String getToken() {
    return "intersectionclass";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CONNECTIVES_AND_ENUMERATION;
  }
}
