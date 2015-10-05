package de.linkvt.bachelor.features.special.properties.parallel;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public abstract class MultipleParallelPropertiesFeature extends Feature {

  private String propertyBaseIri;
  private int propertyCount;

  public MultipleParallelPropertiesFeature(String propertyBaseIri, int propertyCount) {
    this.propertyBaseIri = propertyBaseIri;
    this.propertyCount = propertyCount;
  }

  public void addPropertiesBetweenClasses(OWLClass domain, OWLClass range) {
    for (int i = 1; i <= propertyCount; i++) {
      addProperty(domain, featurePool.getExclusiveProperty(propertyBaseIri + "_" + i), range);
    }
  }

  @Override
  public String getName() {
    return propertyCount + " parallel properties";
  }

  @Override
  public String getToken() {
    return propertyCount + "parallel";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.SPECIAL_TEST_CASES;
  }

}
