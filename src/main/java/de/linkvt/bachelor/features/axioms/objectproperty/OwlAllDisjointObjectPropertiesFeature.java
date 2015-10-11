package de.linkvt.bachelor.features.axioms.objectproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlAllDisjointObjectPropertiesFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty p1 = featurePool.getExclusiveProperty(":allDisjointObjectProperties_Property1");
    OWLObjectProperty p2 = featurePool.getExclusiveProperty(":allDisjointObjectProperties_Property2");
    OWLObjectProperty p3 = featurePool.getExclusiveProperty(":allDisjointObjectProperties_Property3");

    addAxiomToOntology(factory.getOWLDisjointObjectPropertiesAxiom(p1, p2, p3));

    addToGenericDomainAndNewRange(p1, featurePool.getExclusiveClass(":DisjointObjectProperty_Range1"));
    addToGenericDomainAndNewRange(p2, featurePool.getExclusiveClass(":DisjointObjectProperty_Range2"));
    addToGenericDomainAndNewRange(p3, featurePool.getExclusiveClass(":DisjointObjectProperty_Range3"));
  }

  @Override
  public String getName() {
    return "owl:AllDisjointProperties";
  }

  @Override
  public String getToken() {
    return "alldisjointproperties";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTIES;
  }
}
