package de.linkvt.ontobench.features.special.properties.reflexive;

import org.springframework.stereotype.Component;

@Component
public class FourReflexivePropertiesFeature extends MultipleReflexivePropertiesFeature {

  public static final String BASE_IRI = ":FourSymmetricProperties";
  public static final int PROPERTY_COUNT = 4;

  public FourReflexivePropertiesFeature() {
    super(BASE_IRI, PROPERTY_COUNT);
  }

}
