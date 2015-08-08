package de.linkvt.bachelor.presets;

import de.linkvt.bachelor.features.classes.axioms.OwlDisjointWithFeature;
import de.linkvt.bachelor.features.classes.axioms.OwlOneOfFeature;
import de.linkvt.bachelor.features.classes.cardinalities.OwlCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.OwlMaxCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.OwlMinCardinalityFeature;
import de.linkvt.bachelor.features.classes.setoperators.OwlComplementOfFeature;
import de.linkvt.bachelor.features.classes.setoperators.OwlIntersectionOfFeature;
import de.linkvt.bachelor.features.classes.setoperators.OwlUnionOfFeature;
import de.linkvt.bachelor.features.classes.values.OwlHasValueClassFeature;

import org.springframework.stereotype.Component;

@Component
public class OwlDlPreset extends OwlLitePreset {
  @Override
  protected void initialize() {
    super.initialize();

    addFeatures(OwlMaxCardinalityFeature.class, OwlMinCardinalityFeature.class, OwlCardinalityFeature.class);
    addFeatures(OwlHasValueClassFeature.class);
    addFeatures(OwlUnionOfFeature.class, OwlComplementOfFeature.class, OwlIntersectionOfFeature.class);
    addFeatures(OwlOneOfFeature.class);
    addFeatures(OwlDisjointWithFeature.class);
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
