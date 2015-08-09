package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlInverseOfPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getReusableClass();
    OWLClass range = featurePool.getExclusiveClass("Child");

    OWLObjectProperty property = featurePool.getExclusiveProperty("hasChild");
    addProperty(domain, property, range);

    OWLObjectProperty inverseProperty = featurePool.getExclusiveProperty("hasParent");
    addProperty(range, inverseProperty, domain);

    addAxiomToOntology(factory.getOWLInverseObjectPropertiesAxiom(property, inverseProperty));
  }

  @Override
  public String getName() {
    return "owl:inverseOf";
  }

  @Override
  public String getToken() {
    return "inverseprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.PROPERTY;
  }
}
