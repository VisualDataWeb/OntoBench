package de.linkvt.bachelor.presets;

import de.linkvt.bachelor.features.classes.cardinalities.data.OwlDataCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.data.OwlDataMaxCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.data.OwlDataMaxQualifiedCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.data.OwlDataMinCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.data.OwlDataMinQualifiedCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.data.OwlDataQualifiedCardinalityFeature;
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
    addFeatures(OwlDataCardinalityFeature.class, OwlDataMinCardinalityFeature.class, OwlDataMaxCardinalityFeature.class);
    addFeatures(OwlDataQualifiedCardinalityFeature.class, OwlDataMinQualifiedCardinalityFeature.class, OwlDataMaxQualifiedCardinalityFeature.class);
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
