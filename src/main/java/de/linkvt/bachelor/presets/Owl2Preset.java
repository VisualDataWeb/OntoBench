package de.linkvt.bachelor.presets;

import de.linkvt.bachelor.features.classes.cardinalities.object.OwlObjectMaxQualifiedCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.object.OwlObjectMinQualifiedCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.object.OwlObjectQualifiedCardinalityFeature;
import de.linkvt.bachelor.features.classes.values.data.OwlDataAllValuesFromFeature;
import de.linkvt.bachelor.features.classes.values.data.OwlDataHasValueFeature;
import de.linkvt.bachelor.features.classes.values.data.OwlDataSomeValuesFromFeature;
import de.linkvt.bachelor.features.classes.values.object.OwlHasSelfFeature;

import org.springframework.stereotype.Component;

@Component
public class Owl2Preset extends Preset {
  @Override
  protected void initialize() {
    addFeatures(OwlHasSelfFeature.class);
    addFeatures(OwlDataAllValuesFromFeature.class, OwlDataSomeValuesFromFeature.class, OwlDataHasValueFeature.class);
    addFeatures(OwlObjectQualifiedCardinalityFeature.class, OwlObjectMinQualifiedCardinalityFeature.class, OwlObjectMaxQualifiedCardinalityFeature.class);
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
