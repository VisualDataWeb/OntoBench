package de.linkvt.bachelor.presets;

import de.linkvt.bachelor.features.classes.cardinalities.OwlQualifiedCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.OwlMaxQualifiedCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.OwlMinQualifiedCardinalityFeature;
import de.linkvt.bachelor.features.classes.values.OwlHasSelfFeature;

import org.springframework.stereotype.Component;

@Component
public class Owl2Preset extends Preset {
  @Override
  protected void initialize() {
    addFeatures(OwlHasSelfFeature.class);
    addFeatures(OwlQualifiedCardinalityFeature.class, OwlMinQualifiedCardinalityFeature.class, OwlMaxQualifiedCardinalityFeature.class);
  }

  @Override
  public String getName() {
    return "OWL 2 (WIP)";
  }

  @Override
  public int getIndex() {
    return 2;
  }
}
