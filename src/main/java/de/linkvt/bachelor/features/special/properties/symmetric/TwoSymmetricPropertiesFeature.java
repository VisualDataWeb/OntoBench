package de.linkvt.bachelor.features.special.properties.symmetric;

import org.springframework.stereotype.Component;

@Component
public class TwoSymmetricPropertiesFeature extends MultipleSymmetricPropertiesFeature {

  public static final String BASE_IRI = ":TwoSymmetricProperties";
  public static final int PROPERTY_COUNT = 2;

  public TwoSymmetricPropertiesFeature() {
    super(BASE_IRI, PROPERTY_COUNT);
  }

}
