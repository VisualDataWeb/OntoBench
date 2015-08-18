package de.linkvt.bachelor.features.classexpressions.restrictions.object.value;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectSomeValuesFromOwl2RlFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":someValuesFromOwl2Rl");
    OWLClass someValues = featurePool.getExclusiveClass(":SomeOwl2RlValues");
    OWLObjectSomeValuesFrom restriction = factory.getOWLObjectSomeValuesFrom(property, someValues);
    OWLClass manyValues = featurePool.getExclusiveClass(":ManyOwl2RlValues");

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(restriction, manyValues));
  }

  @Override
  public String getName() {
    return "owl:someValuesFrom (Object Property, OWL 2 RL)";
  }

  @Override
  public String getToken() {
    return "somevaluesrlobject";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
