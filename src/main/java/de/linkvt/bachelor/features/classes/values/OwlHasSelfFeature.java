package de.linkvt.bachelor.features.classes.values;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlHasSelfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty loves = featurePool.getExclusiveProperty("loves");

    OWLClass narcisticPerson = featurePool.getExclusiveClass("NarcisticPerson");

    OWLObjectHasSelf restriction = factory.getOWLObjectHasSelf(loves);
    addAxiomToOntology(factory.getOWLEquivalentClassesAxiom(narcisticPerson, restriction));
  }

  @Override
  public String getName() {
    return "owl:hasSelf";
  }

  @Override
  public String getToken() {
    return "hasself";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS;
  }
}
