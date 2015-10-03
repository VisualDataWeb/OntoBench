package de.linkvt.bachelor.features.classexpressions.restrictions.object.value;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectAllValuesFromFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":objectAllValuesFromProperty");
    OWLClass range = featurePool.getExclusiveClass(":ObjectAllValuesFromRange");

    OWLObjectAllValuesFrom restriction = factory.getOWLObjectAllValuesFrom(property, range);

    OWLClass allValuesFrom = featurePool.getExclusiveClass(":ObjectAllValuesFrom");
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(allValuesFrom, restriction));
  }

  @Override
  public String getName() {
    return "owl:allValuesFrom (Object Property)";
  }

  @Override
  public String getToken() {
    return "allvaluesobject";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
