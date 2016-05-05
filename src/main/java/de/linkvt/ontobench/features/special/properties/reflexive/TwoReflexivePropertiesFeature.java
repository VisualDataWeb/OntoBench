package de.linkvt.ontobench.features.special.properties.reflexive;

import org.springframework.stereotype.Component;

@Component
public class TwoReflexivePropertiesFeature extends MultipleReflexivePropertiesFeature {

  public static final String BASE_IRI = ":TwoSymmetricProperties";
  public static final int PROPERTY_COUNT = 2;

  public TwoReflexivePropertiesFeature() {
    super(BASE_IRI, PROPERTY_COUNT);
  }

}
