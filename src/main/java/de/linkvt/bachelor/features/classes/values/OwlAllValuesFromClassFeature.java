package de.linkvt.bachelor.features.classes.values;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlAllValuesFromClassFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty hasMaker = featurePool.getExclusiveProperty("hasMaker");

    OWLClass winery = featurePool.getExclusiveClass("Winery");
    OWLClass wine = featurePool.getExclusiveClass("Wine");
    OWLObjectAllValuesFrom restriction = factory.getOWLObjectAllValuesFrom(hasMaker, winery);
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(wine, restriction));
  }

  @Override
  public String getName() {
    return "owl:allValuesFrom a class";
  }

  @Override
  public String getToken() {
    return "allvaluesclass";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS;
  }
}
