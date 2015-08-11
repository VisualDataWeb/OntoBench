package de.linkvt.bachelor.features.visualization;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public class MultipleLinksFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getReusableClass("MultiLinkDomain");
    OWLClass range = featurePool.getExclusiveClass("MultiLinkRange");

    addProperty(domain, featurePool.getExclusiveProperty("MultiProperty1"), range);
    addProperty(domain, featurePool.getExclusiveProperty("MultiProperty2"), range);
    addProperty(domain, featurePool.getExclusiveProperty("MultiProperty3"), range);
    addProperty(domain, featurePool.getExclusiveProperty("MultiProperty4"), range);
    addProperty(domain, featurePool.getExclusiveProperty("MultiProperty5"), range);
  }

  @Override
  public String getName() {
    return "Five properties with the same domain and range";
  }

  @Override
  public String getToken() {
    return "multipleproperties";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.VISUALIZATION;
  }
}
