package de.linkvt.bachelor.features.classexpressions.restrictions.object.value;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectSomeValuesFromFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty builtBy = featurePool.getExclusiveProperty(":builtBy");

    OWLClass mercedes = featurePool.getExclusiveClass(":Mercedes");
    OWLClass car = featurePool.getExclusiveClass(":Car");
    OWLObjectSomeValuesFrom restriction = factory.getOWLObjectSomeValuesFrom(builtBy, mercedes);
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(car, restriction));
  }

  @Override
  public String getName() {
    return "owl:someValuesFrom (Object Property)";
  }

  @Override
  public String getToken() {
    return "somevaluesobject";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
