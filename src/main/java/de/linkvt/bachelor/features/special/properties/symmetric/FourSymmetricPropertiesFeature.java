package de.linkvt.bachelor.features.special.properties.symmetric;

import org.springframework.stereotype.Component;

@Component
public class FourSymmetricPropertiesFeature extends MultipleSymmetricPropertiesFeature {

  public static final String BASE_IRI = ":FourSymmetricProperties";
  public static final int PROPERTY_COUNT = 4;

  public FourSymmetricPropertiesFeature() {
    super(BASE_IRI, PROPERTY_COUNT);
  }

}
