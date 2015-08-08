package de.linkvt.bachelor.presets;

import de.linkvt.bachelor.features.annotations.owl.OwlAnnotationPropertyFeature;
import de.linkvt.bachelor.features.annotations.owl.OwlVersionInfoFeature;
import de.linkvt.bachelor.features.annotations.rdfs.RdfsCommentFeature;
import de.linkvt.bachelor.features.annotations.rdfs.RdfsCommentOnOntologyFeature;
import de.linkvt.bachelor.features.annotations.rdfs.RdfsLabelFeature;
import de.linkvt.bachelor.features.annotations.rdfs.RdfsLabelOnOntologyFeature;
import de.linkvt.bachelor.features.classes.OwlClassFeature;
import de.linkvt.bachelor.features.classes.OwlDeprecatedClassFeature;
import de.linkvt.bachelor.features.classes.OwlNothingFeature;
import de.linkvt.bachelor.features.classes.OwlThingFeature;
import de.linkvt.bachelor.features.classes.axioms.OwlEquivalentClassFeature;
import de.linkvt.bachelor.features.classes.axioms.RdfsSubClassOfFeature;
import de.linkvt.bachelor.features.classes.cardinalities.owllite.OwlLiteOwlCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.owllite.OwlLiteOwlMaxCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.owllite.OwlLiteOwlMinCardinalityFeature;
import de.linkvt.bachelor.features.classes.setoperators.OwlIntersectionOfFeature;
import de.linkvt.bachelor.features.classes.values.OwlAllValuesFromClassFeature;
import de.linkvt.bachelor.features.classes.values.OwlSomeValuesFromClassFeature;
import de.linkvt.bachelor.features.individuals.OwlAllDifferentFeature;
import de.linkvt.bachelor.features.individuals.OwlSameAsFeature;
import de.linkvt.bachelor.features.properties.OwlDatatypePropertyFeature;
import de.linkvt.bachelor.features.properties.OwlDeprecatedPropertyFeature;
import de.linkvt.bachelor.features.properties.OwlEquivalentPropertyFeature;
import de.linkvt.bachelor.features.properties.OwlFunctionalPropertyFeature;
import de.linkvt.bachelor.features.properties.OwlInverseFunctionalPropertyFeature;
import de.linkvt.bachelor.features.properties.OwlInverseOfPropertyFeature;
import de.linkvt.bachelor.features.properties.OwlObjectPropertyFeature;
import de.linkvt.bachelor.features.properties.OwlSymmetricPropertyFeature;
import de.linkvt.bachelor.features.properties.OwlTransitivePropertyFeature;
import de.linkvt.bachelor.features.properties.RdfsDomainFeature;
import de.linkvt.bachelor.features.properties.RdfsRangeFeature;
import de.linkvt.bachelor.features.properties.RdfsSubPropertyOfFeature;
import de.linkvt.bachelor.features.properties.UnboundPropertyFeature;

import org.springframework.stereotype.Component;

@Component
public class OwlLitePreset extends Preset {
  @Override
  protected void initialize() {
    addFeatures(OwlLiteOwlCardinalityFeature.class, OwlLiteOwlMaxCardinalityFeature.class, OwlLiteOwlMinCardinalityFeature.class);
    addFeatures(OwlAllValuesFromClassFeature.class, OwlSomeValuesFromClassFeature.class);
    addFeatures(OwlClassFeature.class, OwlThingFeature.class, OwlNothingFeature.class);
    addFeatures(OwlEquivalentClassFeature.class);
    addFeatures(OwlDeprecatedClassFeature.class);
    addFeatures(OwlIntersectionOfFeature.class);

    addFeatures(OwlObjectPropertyFeature.class);
    addFeatures(RdfsDomainFeature.class, RdfsRangeFeature.class, UnboundPropertyFeature.class);
    addFeatures(RdfsSubClassOfFeature.class);
    addFeatures(RdfsSubPropertyOfFeature.class);
    addFeatures(OwlEquivalentPropertyFeature.class);
    addFeatures(OwlDeprecatedPropertyFeature.class);
    addFeatures(OwlInverseOfPropertyFeature.class);
    addFeatures(OwlTransitivePropertyFeature.class, OwlSymmetricPropertyFeature.class);
    addFeatures(OwlFunctionalPropertyFeature.class, OwlInverseFunctionalPropertyFeature.class);

    addFeatures(OwlSameAsFeature.class, OwlAllDifferentFeature.class);

    addFeatures(OwlDatatypePropertyFeature.class);

    addFeatures(OwlAnnotationPropertyFeature.class);
    addFeatures(OwlVersionInfoFeature.class);
    addFeatures(RdfsCommentFeature.class, RdfsCommentOnOntologyFeature.class);
    addFeatures(RdfsLabelFeature.class, RdfsLabelOnOntologyFeature.class);
  }

  @Override
  public String getName() {
    return "OWL Lite";
  }

  @Override
  public int getIndex() {
    return 0;
  }
}
