package de.linkvt.bachelor.features.classexpressions.restrictions.object.cardinality;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectMaxCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getReusablePropertyAndRemoveFromPool();
    OWLClass range = featurePool.getExclusiveClass(":MaxCardinalityRange");
    addToGenericDomainAndNewRange(property, range);

    OWLObjectMaxCardinality maxCardinality = factory.getOWLObjectMaxCardinality(8, property);
    OWLAxiom axiom = factory.getOWLSubClassOfAxiom(range, maxCardinality);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:maxCardinality (Object Property)";
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
