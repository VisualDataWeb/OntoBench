package de.linkvt.bachelor.features.special.parallelproperties;

import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public class EightParallelPropertiesFeature extends MultipleParallelPropertiesFeature {

  public static final String PROPERTY_BASE_IRI = ":EightParallelProperties";
  public static final int PROPERTY_COUNT = 8;

  public EightParallelPropertiesFeature() {
    super(PROPERTY_BASE_IRI, PROPERTY_COUNT);
  }

  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getExclusiveClass(":EightParallelPropertiesDomain");
    OWLClass range = featurePool.getExclusiveClass(":EightParallelPropertiesRange");
    addPropertiesBetweenClasses(domain, range);
  }

}
