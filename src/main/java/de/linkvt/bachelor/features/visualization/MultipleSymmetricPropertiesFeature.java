package de.linkvt.bachelor.features.visualization;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public class MultipleSymmetricPropertiesFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getExclusiveClass("MultipleSymmetricProperties");

    addProperty(domain, featurePool.getExclusiveProperty("MultiSymmetric1"), domain);
    addProperty(domain, featurePool.getExclusiveProperty("MultiSymmetric2"), domain);
    addProperty(domain, featurePool.getExclusiveProperty("MultiSymmetric3"), domain);
    addProperty(domain, featurePool.getExclusiveProperty("MultiSymmetric4"), domain);
    addProperty(domain, featurePool.getExclusiveProperty("MultiSymmetric5"), domain);
  }

  @Override
  public String getName() {
    return "Five symmetric properties";
  }

  @Override
  public String getToken() {
    return "multiplesymmetric";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.VISUALIZATION;
  }
}
