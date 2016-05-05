package de.linkvt.ontobench.features.special.properties.reflexive;

import org.springframework.stereotype.Component;

@Component
public class SixReflexivePropertiesFeature extends MultipleReflexivePropertiesFeature {

  public static final String BASE_IRI = ":SixSymmetricProperties";
  public static final int PROPERTY_COUNT = 6;

  public SixReflexivePropertiesFeature() {
    super(BASE_IRI, PROPERTY_COUNT);
  }

}
