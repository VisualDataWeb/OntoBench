package de.linkvt.ontobench.features.classexpressions.restrictions.object.value;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectSomeValuesFromFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":objectSomeValuesFromProperty");
    OWLClass range = featurePool.getExclusiveClass(":ObjectSomeValuesFromRange");

    OWLClass someValuesFrom = featurePool.getExclusiveClass(":ObjectSomeValuesFrom");
    OWLObjectSomeValuesFrom restriction = factory.getOWLObjectSomeValuesFrom(property, range);
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(someValuesFrom, restriction));
  }

  @Override
  public String getName() {
    return "owl:someValuesFrom";
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
