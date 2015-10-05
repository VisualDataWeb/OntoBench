package de.linkvt.bachelor.features.special.properties.reflexive;

import org.springframework.stereotype.Component;

@Component
public class ThreeReflexivePropertiesFeature extends MultipleReflexivePropertiesFeature {

  public static final String BASE_IRI = ":ThreeSymmetricProperties";
  public static final int PROPERTY_COUNT = 3;

  public ThreeReflexivePropertiesFeature() {
    super(BASE_IRI, PROPERTY_COUNT);
  }

}
