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
    OWLObjectProperty property = featurePool.getExclusiveProperty(":objectSomeValuesFromProperty_RL");
    OWLClass range = featurePool.getExclusiveClass(":ObjectSomeValuesFromRange_RL");

    OWLClass someValuesFrom = featurePool.getExclusiveClass(":ObjectSomeValuesFrom_RL");
    OWLObjectSomeValuesFrom restriction = factory.getOWLObjectSomeValuesFrom(property, range);
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(restriction, someValuesFrom));
  }

  @Override
  public String getName() {
    return "owl:someValuesFrom";
  }

  @Override
  public String getClarification() {
    return "adjusted to OWL 2 RL";
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
