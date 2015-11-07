package de.linkvt.bachelor.features.special.properties.reflexive;

import org.springframework.stereotype.Component;

@Component
public class OneReflexivePropertiesFeature extends MultipleReflexivePropertiesFeature {

  public static final String BASE_IRI = ":OneSymmetricProperty";
  public static final int PROPERTY_COUNT = 1;

  public OneReflexivePropertiesFeature() {
    super(BASE_IRI, PROPERTY_COUNT);
  }

}
