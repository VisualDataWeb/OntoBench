package de.linkvt.bachelor.features.classes.values;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.springframework.stereotype.Component;

@Component
public class OwlSomeValuesFromClassFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty builtBy = featurePool.getExclusiveProperty("builtBy");

    OWLClass mercedes = featurePool.getExclusiveClass("Mercedes");
    OWLClass car = featurePool.getExclusiveClass("Car");
    OWLObjectSomeValuesFrom restriction = factory.getOWLObjectSomeValuesFrom(builtBy, mercedes);
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(car, restriction));
  }

  @Override
  public String getName() {
    return "owl:someValuesFrom a class";
  }

  @Override
  public String getToken() {
    return "somevaluesclass";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS;
  }
}
