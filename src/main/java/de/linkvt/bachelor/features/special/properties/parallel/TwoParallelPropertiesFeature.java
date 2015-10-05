package de.linkvt.bachelor.features.special.properties.parallel;

import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public class TwoParallelPropertiesFeature extends MultipleParallelPropertiesFeature {

  public static final String PROPERTY_BASE_IRI = ":TwoParallelProperties";
  public static final int PROPERTY_COUNT = 2;

  public TwoParallelPropertiesFeature() {
    super(PROPERTY_BASE_IRI, PROPERTY_COUNT);
  }

  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getExclusiveClass(":TwoParallelPropertiesDomain");
    OWLClass range = featurePool.getExclusiveClass(":ThreeParallelPropertiesDomain");
    addPropertiesBetweenClasses(domain, range);
  }

}
