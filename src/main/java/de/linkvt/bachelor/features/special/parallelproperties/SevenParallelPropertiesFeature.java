package de.linkvt.bachelor.features.special.parallelproperties;

import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public class SevenParallelPropertiesFeature extends MultipleParallelPropertiesFeature {

  public static final String PROPERTY_BASE_IRI = ":SevenParallelProperties";
  public static final int PROPERTY_COUNT = 7;

  public SevenParallelPropertiesFeature() {
    super(PROPERTY_BASE_IRI, PROPERTY_COUNT);
  }

  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getExclusiveClass(":SevenParallelPropertiesDomain");
    OWLClass range = featurePool.getExclusiveClass(":EightParallelPropertiesDomain");
    addPropertiesBetweenClasses(domain, range);
  }

}
