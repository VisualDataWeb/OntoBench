package de.linkvt.bachelor.features.classexpressions.connectivesandenumeration;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectComplementOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass positive = featurePool.getExclusiveClass(":Positive");
    OWLObjectComplementOf negative = factory.getOWLObjectComplementOf(positive);

    OWLClass owlClass = featurePool.getExclusiveClass(":Negative");

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(owlClass, negative));
  }

  @Override
  public String getName() {
    return "owl:complementOf (Class)";
  }

  @Override
  public String getToken() {
    return "complementclass";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CONNECTIVES_AND_ENUMERATION;
  }
}
