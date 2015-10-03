package de.linkvt.bachelor.features.axioms.objectproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectPropertyDisjointWithFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty p1 = featurePool.getExclusiveProperty(":objectPropertyDisjointWith_Property1");
    OWLObjectProperty p2 = featurePool.getExclusiveProperty(":objectPropertyDisjointWith_Property2");

    addAxiomToOntology(factory.getOWLDisjointObjectPropertiesAxiom(p1, p2));

    addToGenericDomainAndNewRange(p1, featurePool.getExclusiveClass(":ObjectPropertyDisjointWith_Range1"));
    addToGenericDomainAndNewRange(p2, featurePool.getExclusiveClass(":ObjectPropertyDisjointWith_Range2"));
  }

  @Override
  public String getName() {
    return "owl:propertyDisjointWith (Object Property)";
  }

  @Override
  public String getToken() {
    return "propertydisjointwith";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_AXIOMS;
  }
}
