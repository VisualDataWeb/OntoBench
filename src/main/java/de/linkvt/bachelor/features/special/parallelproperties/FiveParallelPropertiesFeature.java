package de.linkvt.bachelor.features.special.parallelproperties;

import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public class FiveParallelPropertiesFeature extends MultipleParallelPropertiesFeature {

  public static final String PROPERTY_BASE_IRI = ":FiveParallelProperties";
  public static final int PROPERTY_COUNT = 5;

  public FiveParallelPropertiesFeature() {
    super(PROPERTY_BASE_IRI, PROPERTY_COUNT);
  }

  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getExclusiveClass(":FiveParallelPropertiesDomain");
    OWLClass range = featurePool.getExclusiveClass(":SixParallelPropertiesDomain");
    addPropertiesBetweenClasses(domain, range);
  }

}
