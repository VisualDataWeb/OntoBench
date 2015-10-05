package de.linkvt.bachelor.features.special.individuals;

import org.springframework.stereotype.Component;

@Component
public class HundredIndividualsFeature extends MultipleIndividualsFeature {

  private static final String BASE_IRI = ":HundredIndividuals";
  private static final int INDIVIDUAL_COUNT = 100;

  public HundredIndividualsFeature() {
    super(BASE_IRI, INDIVIDUAL_COUNT);
  }

}
