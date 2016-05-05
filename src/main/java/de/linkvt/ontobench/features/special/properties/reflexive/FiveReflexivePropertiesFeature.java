package de.linkvt.ontobench.features.special.properties.reflexive;

import org.springframework.stereotype.Component;

@Component
public class FiveReflexivePropertiesFeature extends MultipleReflexivePropertiesFeature {

  public static final String BASE_IRI = ":FiveSymmetricProperties";
  public static final int PROPERTY_COUNT = 5;

  public FiveReflexivePropertiesFeature() {
    super(BASE_IRI, PROPERTY_COUNT);
  }

}
