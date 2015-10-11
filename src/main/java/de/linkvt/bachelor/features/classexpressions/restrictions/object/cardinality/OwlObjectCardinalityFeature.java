package de.linkvt.bachelor.features.classexpressions.restrictions.object.cardinality;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":objectExactCardinalityProperty");
    OWLClass range = featurePool.getExclusiveClass(":ObjectExactCardinalityRange");
    addToGenericDomainAndNewRange(property, range);

    OWLObjectExactCardinality exactCardinality = factory.getOWLObjectExactCardinality(4, property);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, exactCardinality));
  }

  @Override
  public String getName() {
    return "owl:cardinality";
  }

  @Override
  public String getToken() {
    return "cardinality";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
