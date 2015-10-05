package de.linkvt.bachelor.features.special.properties.reflexive;

import org.springframework.stereotype.Component;

@Component
public class SevenReflexivePropertiesFeature extends MultipleReflexivePropertiesFeature {

  public static final String BASE_IRI = ":SevenSymmetricProperties";
  public static final int PROPERTY_COUNT = 7;

  public SevenReflexivePropertiesFeature() {
    super(BASE_IRI, PROPERTY_COUNT);
  }

}
