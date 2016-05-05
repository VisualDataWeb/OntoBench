package de.linkvt.ontobench.features.special.properties.reflexive;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public abstract class MultipleReflexivePropertiesFeature extends Feature {

  private String baseIri;
  private int propertyCount;

  public MultipleReflexivePropertiesFeature(String baseIri, int propertyCount) {
    this.baseIri = baseIri;
    this.propertyCount = propertyCount;
  }

  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getExclusiveClass(baseIri);
    for (int i = 1; i <= propertyCount; i++) {
      String propertyIri = convertToCamelCaseIri(baseIri);
      addProperty(domain, featurePool.getExclusiveProperty(propertyIri + "_" + i), domain);
    }
  }

  private String convertToCamelCaseIri(String iri) {
    return iri.substring(0, 1) + Character.toLowerCase(iri.charAt(1)) + iri.substring(2);
  }

  @Override
  public String getName() {
    return propertyCount + " reflexive " + (propertyCount <= 1 ? "property" : "properties");
  }

  @Override
  public String getToken() {
    return propertyCount + "reflexive";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.SPECIAL_TEST_CASES;
  }

}
