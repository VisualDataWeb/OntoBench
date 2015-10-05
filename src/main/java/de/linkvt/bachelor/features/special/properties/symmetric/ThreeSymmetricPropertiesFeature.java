package de.linkvt.bachelor.features.special.properties.symmetric;

import org.springframework.stereotype.Component;

@Component
public class ThreeSymmetricPropertiesFeature extends MultipleSymmetricPropertiesFeature {

  public static final String BASE_IRI = ":ThreeSymmetricProperties";
  public static final int PROPERTY_COUNT = 3;

  public ThreeSymmetricPropertiesFeature() {
    super(BASE_IRI, PROPERTY_COUNT);
  }

}
