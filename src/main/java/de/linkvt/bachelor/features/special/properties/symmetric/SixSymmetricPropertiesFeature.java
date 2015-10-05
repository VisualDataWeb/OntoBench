package de.linkvt.bachelor.features.special.properties.symmetric;

import org.springframework.stereotype.Component;

@Component
public class SixSymmetricPropertiesFeature extends MultipleSymmetricPropertiesFeature {

  public static final String BASE_IRI = ":SixSymmetricProperties";
  public static final int PROPERTY_COUNT = 6;

  public SixSymmetricPropertiesFeature() {
    super(BASE_IRI, PROPERTY_COUNT);
  }

}
