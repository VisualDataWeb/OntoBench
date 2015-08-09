package de.linkvt.bachelor.presets;

import de.linkvt.bachelor.features.classes.axioms.OwlDisjointWithFeature;
import de.linkvt.bachelor.features.classes.axioms.OwlOneOfFeature;
import de.linkvt.bachelor.features.classes.cardinalities.object.OwlObjectCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.object.OwlObjectMaxCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.object.OwlObjectMinCardinalityFeature;
import de.linkvt.bachelor.features.classes.setoperators.OwlComplementOfFeature;
import de.linkvt.bachelor.features.classes.setoperators.OwlIntersectionOfFeature;
import de.linkvt.bachelor.features.classes.setoperators.OwlUnionOfFeature;
import de.linkvt.bachelor.features.classes.values.OwlHasValueClassFeature;
import de.linkvt.bachelor.features.datatypes.EnumeratedRdfsDatatypeFeature;

import org.springframework.stereotype.Component;

@Component
public class OwlDlPreset extends OwlLitePreset {
  @Override
  protected void initialize() {
    super.initialize();

    addFeatures(OwlObjectMaxCardinalityFeature.class, OwlObjectMinCardinalityFeature.class, OwlObjectCardinalityFeature.class);
    addFeatures(OwlHasValueClassFeature.class);
    addFeatures(OwlUnionOfFeature.class, OwlComplementOfFeature.class, OwlIntersectionOfFeature.class);
    addFeatures(OwlOneOfFeature.class);
    addFeatures(OwlDisjointWithFeature.class);

    addFeatures(EnumeratedRdfsDatatypeFeature.class);
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
