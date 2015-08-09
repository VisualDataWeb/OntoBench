package de.linkvt.bachelor.presets;

import de.linkvt.bachelor.features.annotations.OwlDeprecatedClassFeature;
import de.linkvt.bachelor.features.annotations.OwlDeprecatedPropertyFeature;
import de.linkvt.bachelor.features.annotations.ontology.owl.OwlAnnotationPropertyFeature;
import de.linkvt.bachelor.features.annotations.ontology.owl.OwlVersionInfoFeature;
import de.linkvt.bachelor.features.annotations.ontology.rdfs.RdfsCommentFeature;
import de.linkvt.bachelor.features.annotations.ontology.rdfs.RdfsCommentOnOntologyFeature;
import de.linkvt.bachelor.features.annotations.ontology.rdfs.RdfsLabelFeature;
import de.linkvt.bachelor.features.annotations.ontology.rdfs.RdfsLabelOnOntologyFeature;
import de.linkvt.bachelor.features.assertions.OwlAllDifferentFeature;
import de.linkvt.bachelor.features.assertions.OwlSameAsFeature;
import de.linkvt.bachelor.features.axioms.classexpression.OwlEquivalentClassFeature;
import de.linkvt.bachelor.features.axioms.classexpression.RdfsSubClassOfFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlEquivalentObjectPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlFunctionalObjectPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlInverseFunctionalPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlInverseOfPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlSymmetricPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlTransitivePropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.RdfsObjectDomainFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.RdfsObjectRangeFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.RdfsObjectSubPropertyOfFeature;
import de.linkvt.bachelor.features.classexpressions.predefinedandnamed.OwlClassFeature;
import de.linkvt.bachelor.features.classexpressions.predefinedandnamed.OwlNothingFeature;
import de.linkvt.bachelor.features.classexpressions.predefinedandnamed.OwlThingFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.cardinality.owllite.OwlLiteOwlObjectCardinalityFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.cardinality.owllite.OwlLiteOwlObjectMaxCardinalityFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.cardinality.owllite.OwlLiteOwlObjectMinCardinalityFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.value.OwlObjectAllValuesFromFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.value.OwlObjectSomeValuesFromFeature;
import de.linkvt.bachelor.features.properties.dataproperty.OwlDatatypePropertyFeature;
import de.linkvt.bachelor.features.properties.objectproperty.OwlObjectPropertyFeature;
import de.linkvt.bachelor.features.properties.objectproperty.UnboundObjectPropertyFeature;

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
    addFeatures(RdfsObjectDomainFeature.class, RdfsObjectRangeFeature.class, UnboundObjectPropertyFeature.class);
    addFeatures(RdfsSubClassOfFeature.class);
    addFeatures(RdfsObjectSubPropertyOfFeature.class);
    addFeatures(OwlEquivalentObjectPropertyFeature.class);
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
