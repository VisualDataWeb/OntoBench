package de.linkvt.bachelor.features.special.properties.parallel;

import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public class SixParallelPropertiesFeature extends MultipleParallelPropertiesFeature {

  public static final String PROPERTY_BASE_IRI = ":SixParallelProperties";
  public static final int PROPERTY_COUNT = 6;

  public SixParallelPropertiesFeature() {
    super(PROPERTY_BASE_IRI, PROPERTY_COUNT);
  }

  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getExclusiveClass(":SixParallelPropertiesDomain");
    OWLClass range = featurePool.getExclusiveClass(":SevenParallelPropertiesDomain");
    addPropertiesBetweenClasses(domain, range);
  }

}
