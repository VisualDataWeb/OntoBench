package de.linkvt.ontobench.features.classexpressions.restrictions.object.cardinality;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectQualifiedCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":objectExactQualifiedCardinalityProperty");
    OWLClass range = featurePool.getExclusiveClass(":ObjectExactQualifiedCardinalityRange");
    addToGenericDomainAndNewRange(property, range);

    OWLClass qualifier = featurePool.getExclusiveClass(":ObjectExactQualifiedCardinality_Qualifier");
    OWLObjectExactCardinality exactCardinality = factory.getOWLObjectExactCardinality(1, property, qualifier);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, exactCardinality));
  }

  @Override
  public String getName() {
    return "owl:qualifiedCardinality";
  }

  @Override
  public String getToken() {
    return "qualifiedcardinality";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
