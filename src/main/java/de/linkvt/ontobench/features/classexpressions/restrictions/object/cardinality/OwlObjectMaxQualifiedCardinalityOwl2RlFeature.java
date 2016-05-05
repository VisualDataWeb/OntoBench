package de.linkvt.ontobench.features.classexpressions.restrictions.object.cardinality;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectMaxQualifiedCardinalityOwl2RlFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":objectMaxQualifiedCardinalityProperty_RL");
    OWLClass range = featurePool.getExclusiveClass(":ObjectMaxQualifiedCardinalityRange_RL");
    addToGenericDomainAndNewRange(property, range);

    OWLClass qualifier = featurePool.getExclusiveClass(":ObjectMaxQualifiedCardinality_RL_Qualifier");
    OWLObjectMaxCardinality maxCardinality = factory.getOWLObjectMaxCardinality(0, property, qualifier);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, maxCardinality));
  }

  @Override
  public String getName() {
    return "owl:maxQualifiedCardinality";
  }

  @Override
  public String getCompliance() {
    return "OWL 2 RL";
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
