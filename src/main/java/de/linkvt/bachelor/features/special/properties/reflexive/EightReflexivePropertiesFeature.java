package de.linkvt.bachelor.features.special.properties.reflexive;

import org.springframework.stereotype.Component;

@Component
public class EightReflexivePropertiesFeature extends MultipleReflexivePropertiesFeature {

  public static final String BASE_IRI = ":EightSymmetricProperties";
  public static final int PROPERTY_COUNT = 8;

  public EightReflexivePropertiesFeature() {
    super(BASE_IRI, PROPERTY_COUNT);
  }

}
