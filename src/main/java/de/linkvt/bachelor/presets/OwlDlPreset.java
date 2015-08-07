package de.linkvt.bachelor.presets;

import de.linkvt.bachelor.features.classes.cardinalities.OwlCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.OwlMaxCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.OwlMinCardinalityFeature;
import de.linkvt.bachelor.features.classes.values.OwlHasValueClassFeature;

import org.springframework.stereotype.Component;

@Component
public class OwlDlPreset extends OwlLitePreset {
  @Override
  protected void addFeatures() {
    super.addFeatures();

    this.addFeature(OwlMaxCardinalityFeature.class)
        .addFeature(OwlMinCardinalityFeature.class)
        .addFeature(OwlCardinalityFeature.class)
        .addFeature(OwlHasValueClassFeature.class);
  }

  @Override
  public String getName() {
    return "OWL DL (WIP)";
  }

  @Override
  public int getIndex() {
    return 1;
  }
}
