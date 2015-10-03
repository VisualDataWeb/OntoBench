package de.linkvt.bachelor.features.axioms.objectproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlAllDisjointObjectPropertiesFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty p1 = featurePool.getExclusiveProperty(":allDisjointObjectProperties_1");
    OWLObjectProperty p2 = featurePool.getExclusiveProperty(":allDisjointObjectProperties_2");
    OWLObjectProperty p3 = featurePool.getExclusiveProperty(":allDisjointObjectProperties_3");

    addAxiomToOntology(factory.getOWLDisjointObjectPropertiesAxiom(p1, p2, p3));

    addToGenericDomainAndNewRange(p1, featurePool.getExclusiveClass(":DisjointObjectPropertyRange_1"));
    addToGenericDomainAndNewRange(p2, featurePool.getExclusiveClass(":DisjointObjectPropertyRange_2"));
    addToGenericDomainAndNewRange(p3, featurePool.getExclusiveClass(":DisjointObjectPropertyRange_3"));
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
