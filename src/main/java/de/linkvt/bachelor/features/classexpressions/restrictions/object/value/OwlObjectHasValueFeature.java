package de.linkvt.bachelor.features.classexpressions.restrictions.object.value;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectHasValueFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":objectHasValueProperty");

    OWLIndividual value = factory.getOWLNamedIndividual(":ObjectHasValue_Individual", pm);
    OWLObjectHasValue restriction = factory.getOWLObjectHasValue(property, value);

    OWLClass hasValue = featurePool.getExclusiveClass(":ObjectHasValue");
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(hasValue, restriction));
  }

  @Override
  public String getName() {
    return "owl:hasValue";
  }

  @Override
  public String getToken() {
    return "hasvalueobject";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
