package de.linkvt.bachelor.presets;

import de.linkvt.bachelor.features.classes.cardinalities.owllite.OwlLiteOwlCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.owllite.OwlLiteOwlMaxCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.owllite.OwlLiteOwlMinCardinalityFeature;
import de.linkvt.bachelor.features.classes.values.OwlAllValuesFromClassFeature;
import de.linkvt.bachelor.features.classes.values.OwlSomeValuesFromClassFeature;

import org.springframework.stereotype.Component;

@Component
public class OwlLitePreset extends Preset {
  @Override
  protected void addFeatures() {
    this.addFeature(OwlLiteOwlCardinalityFeature.class)
        .addFeature(OwlLiteOwlMaxCardinalityFeature.class)
        .addFeature(OwlLiteOwlMinCardinalityFeature.class)
        .addFeature(OwlAllValuesFromClassFeature.class)
        .addFeature(OwlSomeValuesFromClassFeature.class);
  }

  @Override
  public String getName() {
    return "OWL Lite (WIP)";
  }

  @Override
  public int getIndex() {
    return 0;
  }
}
