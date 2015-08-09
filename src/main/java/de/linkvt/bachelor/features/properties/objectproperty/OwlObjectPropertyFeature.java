package de.linkvt.bachelor.features.properties.objectproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty objectProperty = featurePool.getExclusiveProperty("ObjectProperty");
    OWLClass range = featurePool.getExclusiveClass("ObjectPropertyRange");

    addToGenericDomainAndNewRange(objectProperty, range);
  }

  @Override
  public String getName() {
    return "owl:ObjectProperty";
  }

  @Override
  public String getToken() {
    return "objectprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.PROPERTY_EXPRESSIONS;
  }

  @Override
  public boolean isGeneral() {
    return true;
  }
}
