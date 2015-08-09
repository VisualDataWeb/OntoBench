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
import de.linkvt.bachelor.features.classes.cardinalities.object.owllite.OwlLiteOwlObjectCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.object.owllite.OwlLiteOwlObjectMaxCardinalityFeature;
import de.linkvt.bachelor.features.classes.cardinalities.object.owllite.OwlLiteOwlObjectMinCardinalityFeature;
import de.linkvt.bachelor.features.classes.values.object.OwlObjectAllValuesFromFeature;
import de.linkvt.bachelor.features.classes.values.object.OwlObjectSomeValuesFromFeature;
import de.linkvt.bachelor.features.individuals.OwlAllDifferentFeature;
import de.linkvt.bachelor.features.individuals.OwlSameAsFeature;
import de.linkvt.bachelor.features.properties.OwlDatatypePropertyFeature;
import de.linkvt.bachelor.features.properties.OwlDeprecatedPropertyFeature;
import de.linkvt.bachelor.features.properties.OwlEquivalentPropertyFeature;
import de.linkvt.bachelor.features.properties.OwlFunctionalObjectPropertyFeature;
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
    addFeatures(OwlLiteOwlObjectCardinalityFeature.class, OwlLiteOwlObjectMaxCardinalityFeature.class, OwlLiteOwlObjectMinCardinalityFeature.class);
    addFeatures(OwlObjectAllValuesFromFeature.class, OwlObjectSomeValuesFromFeature.class);
    addFeatures(OwlClassFeature.class, OwlThingFeature.class, OwlNothingFeature.class);
    addFeatures(OwlEquivalentClassFeature.class);
    addFeatures(OwlDeprecatedClassFeature.class);

    addFeatures(OwlObjectPropertyFeature.class);
    addFeatures(RdfsDomainFeature.class, RdfsRangeFeature.class, UnboundPropertyFeature.class);
    addFeatures(RdfsSubClassOfFeature.class);
    addFeatures(RdfsSubPropertyOfFeature.class);
    addFeatures(OwlEquivalentPropertyFeature.class);
    addFeatures(OwlDeprecatedPropertyFeature.class);
    addFeatures(OwlInverseOfPropertyFeature.class);
    addFeatures(OwlTransitivePropertyFeature.class, OwlSymmetricPropertyFeature.class);
    addFeatures(OwlFunctionalObjectPropertyFeature.class, OwlInverseFunctionalPropertyFeature.class);

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
