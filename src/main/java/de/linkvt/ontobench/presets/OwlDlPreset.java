package de.linkvt.ontobench.presets;

import de.linkvt.ontobench.features.axioms.classexpression.OwlDisjointWithFeature;
import de.linkvt.ontobench.features.classexpressions.connectivesandenumeration.OwlObjectComplementOfFeature;
import de.linkvt.ontobench.features.classexpressions.connectivesandenumeration.OwlObjectIntersectionOfFeature;
import de.linkvt.ontobench.features.classexpressions.connectivesandenumeration.OwlObjectOneOfFeature;
import de.linkvt.ontobench.features.classexpressions.connectivesandenumeration.OwlObjectUnionOfFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.cardinality.OwlObjectCardinalityFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.cardinality.OwlObjectMaxCardinalityFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.cardinality.OwlObjectMinCardinalityFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.value.OwlObjectHasValueFeature;
import de.linkvt.ontobench.features.dataranges.OwlDataOneOfFeature;

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
    return "OWL DL";
  }

  @Override
  public int getIndex() {
    return 1;
  }
}
