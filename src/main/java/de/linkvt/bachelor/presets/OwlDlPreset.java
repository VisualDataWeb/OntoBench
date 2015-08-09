package de.linkvt.bachelor.presets;

import de.linkvt.bachelor.features.classes.axioms.OwlDataOneOfFeature;
import de.linkvt.bachelor.features.classes.axioms.OwlDisjointWithFeature;
import de.linkvt.bachelor.features.classes.axioms.OwlObjectOneOfFeature;
import de.linkvt.bachelor.features.classes.cardinalities.object.OwlObjectCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.object.OwlObjectMaxCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.object.OwlObjectMinCardinalityFeature;
import de.linkvt.bachelor.features.classes.setoperators.object.OwlObjectComplementOfFeature;
import de.linkvt.bachelor.features.classes.setoperators.object.OwlObjectIntersectionOfFeature;
import de.linkvt.bachelor.features.classes.setoperators.object.OwlObjectUnionOfFeature;
import de.linkvt.bachelor.features.classes.values.object.OwlObjectHasValueFeature;

import org.springframework.stereotype.Component;

@Component
public class OwlDlPreset extends OwlLitePreset {
  @Override
  protected void initialize() {
    super.initialize();

    addFeatures(OwlObjectMaxCardinalityFeature.class, OwlObjectMinCardinalityFeature.class, OwlObjectCardinalityFeature.class);
    addFeatures(OwlObjectHasValueFeature.class);
    addFeatures(OwlObjectUnionOfFeature.class, OwlObjectComplementOfFeature.class, OwlObjectIntersectionOfFeature.class);
    addFeatures(OwlObjectOneOfFeature.class);
    addFeatures(OwlDisjointWithFeature.class);

    addFeatures(OwlDataOneOfFeature.class);
  }

  @Override
  public String getName() {
    return "OWL DL/Full";
  }

  @Override
  public int getIndex() {
    return 1;
  }
}
