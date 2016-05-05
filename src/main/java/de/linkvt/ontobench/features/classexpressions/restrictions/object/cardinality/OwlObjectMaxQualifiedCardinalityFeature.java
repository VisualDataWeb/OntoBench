package de.linkvt.ontobench.features.classexpressions.restrictions.object.cardinality;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectMaxQualifiedCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":objectMaxQualifiedCardinalityProperty");
    OWLClass range = featurePool.getExclusiveClass(":ObjectMaxQualifiedCardinalityRange");
    addToGenericDomainAndNewRange(property, range);

    OWLClass qualifier = featurePool.getExclusiveClass(":ObjectMaxQualifiedCardinality_Qualifier");
    OWLObjectMaxCardinality maxCardinality = factory.getOWLObjectMaxCardinality(3, property, qualifier);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, maxCardinality));
  }

  @Override
  public String getName() {
    return "owl:maxQualifiedCardinality";
  }

  @Override
  public String getToken() {
    return "maxqualifiedcardinality";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
