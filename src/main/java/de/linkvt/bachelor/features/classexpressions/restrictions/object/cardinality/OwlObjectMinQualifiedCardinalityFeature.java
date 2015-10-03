package de.linkvt.bachelor.features.classexpressions.restrictions.object.cardinality;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectMinQualifiedCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":objectMinQualifiedCardinalityProperty");
    OWLClass range = featurePool.getExclusiveClass(":ObjectMinQualifiedCardinalityRange");
    addToGenericDomainAndNewRange(property, range);

    OWLClass qualifier = featurePool.getExclusiveClass(":ObjectMinQualifiedCardinality_Qualifier");
    OWLObjectMinCardinality minCardinality = factory.getOWLObjectMinCardinality(1, property, qualifier);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, minCardinality));
  }

  @Override
  public String getName() {
    return "owl:minQualifiedCardinality (Object Property)";
  }

  @Override
  public String getToken() {
    return "minqualifiedcardinality";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
