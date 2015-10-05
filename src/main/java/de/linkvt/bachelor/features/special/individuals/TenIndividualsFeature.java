package de.linkvt.bachelor.features.special.individuals;

import org.springframework.stereotype.Component;

@Component
public class TenIndividualsFeature extends MultipleIndividualsFeature {

  private static final String BASE_IRI = ":TenIndividuals";
  private static final int INDIVIDUAL_COUNT = 10;

  public TenIndividualsFeature() {
    super(BASE_IRI, INDIVIDUAL_COUNT);
  }

}
