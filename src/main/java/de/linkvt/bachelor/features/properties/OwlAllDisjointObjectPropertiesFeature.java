package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlAllDisjointObjectPropertiesFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty hasFather = featurePool.getExclusiveProperty("hasFather");
    OWLObjectProperty hasMother = featurePool.getExclusiveProperty("hasMother");
    OWLObjectProperty hasUncle = featurePool.getExclusiveProperty("hasUncle");

    addAxiomToOntology(factory.getOWLDisjointObjectPropertiesAxiom(hasFather, hasMother, hasUncle));

    addToGenericDomainAndNewRange(hasFather, featurePool.getExclusiveClass("Wife"));
    addToGenericDomainAndNewRange(hasMother, featurePool.getExclusiveClass("Child"));
    addToGenericDomainAndNewRange(hasUncle, featurePool.getExclusiveClass("Uncle"));
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
    return FeatureCategory.PROPERTY;
  }
}
