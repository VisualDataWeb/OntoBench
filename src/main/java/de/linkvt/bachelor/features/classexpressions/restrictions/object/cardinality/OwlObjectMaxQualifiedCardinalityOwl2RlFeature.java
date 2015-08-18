package de.linkvt.bachelor.features.classexpressions.restrictions.object.cardinality;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectMaxQualifiedCardinalityOwl2RlFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":owl2RlObjectMaxQualifiedCardinalityProperty");
    OWLClass range = featurePool.getExclusiveClass(":Owl2RlMaxQualifiedCardinalityRange");
    addToGenericDomainAndNewRange(property, range);

    OWLClass affectedClass = featurePool.getExclusiveClass(":Owl2RlMaxCardinalityAffectedClass");
    OWLObjectMaxCardinality maxCardinality = factory.getOWLObjectMaxCardinality(0, property, affectedClass);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, maxCardinality));
  }

  @Override
  public String getName() {
    return "owl:maxQualifiedCardinality (Object Property, OWL 2 RL)";
  }

  @Override
  public String getToken() {
    return "maxqualifiedrlcardinality";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
