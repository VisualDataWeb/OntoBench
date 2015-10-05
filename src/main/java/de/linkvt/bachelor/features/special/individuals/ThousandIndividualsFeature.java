package de.linkvt.bachelor.features.special.individuals;

import org.springframework.stereotype.Component;

@Component
public class ThousandIndividualsFeature extends MultipleIndividualsFeature {

  private static final String BASE_IRI = ":ThousandIndividuals";
  private static final int INDIVIDUAL_COUNT = 1000;

  public ThousandIndividualsFeature() {
    super(BASE_IRI, INDIVIDUAL_COUNT);
  }

  @Override
  public String getName() {
    return "Thousand instances of a class";
  }

  @Override
  public String getToken() {
    return "thousandinstances";
  }

}
