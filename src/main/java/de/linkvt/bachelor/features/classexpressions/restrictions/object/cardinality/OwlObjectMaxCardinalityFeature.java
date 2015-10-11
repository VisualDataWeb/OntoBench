package de.linkvt.bachelor.features.classexpressions.restrictions.object.cardinality;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectMaxCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":objectMaxCardinalityProperty");
    OWLClass range = featurePool.getExclusiveClass(":ObjectMaxCardinalityRange");
    addToGenericDomainAndNewRange(property, range);

    OWLObjectMaxCardinality maxCardinality = factory.getOWLObjectMaxCardinality(8, property);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, maxCardinality));
  }

  @Override
  public String getName() {
    return "owl:maxCardinality";
  }

  @Override
  public String getToken() {
    return "maxcardinality";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
