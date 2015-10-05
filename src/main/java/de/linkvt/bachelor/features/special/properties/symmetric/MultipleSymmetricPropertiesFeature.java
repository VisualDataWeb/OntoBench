package de.linkvt.bachelor.features.special.properties.symmetric;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public abstract class MultipleSymmetricPropertiesFeature extends Feature {

  private String baseIri;
  private int propertyCount;

  public MultipleSymmetricPropertiesFeature(String baseIri, int propertyCount) {
    this.baseIri = baseIri;
    this.propertyCount = propertyCount;
  }

  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getExclusiveClass(baseIri);
    for (int i = 1; i <= propertyCount; i++) {
      addProperty(domain, featurePool.getExclusiveProperty(baseIri + "_" + i), domain);
    }
  }

  @Override
  public String getName() {
    return propertyCount + " symmetric properties";
  }

  @Override
  public String getToken() {
    return propertyCount + "symmetric";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.SPECIAL_TEST_CASES;
  }

}
