package de.linkvt.bachelor.features.special.properties.symmetric;

import org.springframework.stereotype.Component;

@Component
public class EightSymmetricPropertiesFeature extends MultipleSymmetricPropertiesFeature {

  public static final String BASE_IRI = ":EightSymmetricProperties";
  public static final int PROPERTY_COUNT = 8;

  public EightSymmetricPropertiesFeature() {
    super(BASE_IRI, PROPERTY_COUNT);
  }

}
