package de.linkvt.bachelor.features.axioms.objectproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlAllDisjointObjectPropertiesFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property1 = featurePool.getExclusiveProperty(":disjointProperty1");
    OWLObjectProperty property2 = featurePool.getExclusiveProperty(":disjointProperty2");
    OWLObjectProperty property3 = featurePool.getExclusiveProperty(":disjointProperty3");

    addAxiomToOntology(factory.getOWLDisjointObjectPropertiesAxiom(property1, property2, property3));

    addToGenericDomainAndNewRange(property1, featurePool.getExclusiveClass(":DisjointPropertyRange1"));
    addToGenericDomainAndNewRange(property2, featurePool.getExclusiveClass(":DisjointPropertyRange2"));
    addToGenericDomainAndNewRange(property3, featurePool.getExclusiveClass(":DisjointPropertyRange2"));
  }

  @Override
  public String getName() {
    return "owl:AllDisjointProperties (Object Property)";
  }

  @Override
  public String getToken() {
    return "alldisjointproperties";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_AXIOMS;
  }
}
