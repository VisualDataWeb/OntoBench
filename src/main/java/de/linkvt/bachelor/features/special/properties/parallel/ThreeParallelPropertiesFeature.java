package de.linkvt.bachelor.features.special.properties.parallel;

import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public class ThreeParallelPropertiesFeature extends MultipleParallelPropertiesFeature {

  public static final String PROPERTY_BASE_IRI = ":ThreeParallelProperties";
  public static final int PROPERTY_COUNT = 3;

  public ThreeParallelPropertiesFeature() {
    super(PROPERTY_BASE_IRI, PROPERTY_COUNT);
  }

  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getExclusiveClass(":ThreeParallelPropertiesDomain");
    OWLClass range = featurePool.getExclusiveClass(":FourParallelPropertiesDomain");
    addPropertiesBetweenClasses(domain, range);
  }

}
