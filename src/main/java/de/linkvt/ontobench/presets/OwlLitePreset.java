package de.linkvt.ontobench.presets;

import de.linkvt.ontobench.features.annotations.OwlAnnotationPropertyFeature;
import de.linkvt.ontobench.features.annotations.OwlDeprecatedClassFeature;
import de.linkvt.ontobench.features.annotations.OwlDeprecatedPropertyFeature;
import de.linkvt.ontobench.features.annotations.ontology.owl.OwlVersionInfoFeature;
import de.linkvt.ontobench.features.annotations.ontology.rdfs.RdfsCommentFeature;
import de.linkvt.ontobench.features.annotations.ontology.rdfs.RdfsCommentOnOntologyFeature;
import de.linkvt.ontobench.features.annotations.ontology.rdfs.RdfsLabelFeature;
import de.linkvt.ontobench.features.annotations.ontology.rdfs.RdfsLabelOnOntologyFeature;
import de.linkvt.ontobench.features.axioms.classexpression.OwlEquivalentClassFeature;
import de.linkvt.ontobench.features.axioms.classexpression.RdfsSubClassOfFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.OwlDatatypePropertyFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.RdfsDataDomainFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.RdfsDataRangeFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.UnboundDataPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlEquivalentObjectPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlFunctionalObjectPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlInverseFunctionalPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlInverseOfPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlObjectPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlSymmetricPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlTransitivePropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.RdfsObjectDomainFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.RdfsObjectRangeFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.RdfsObjectSubPropertyOfFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.UnboundObjectPropertyFeature;
import de.linkvt.ontobench.features.classexpressions.OwlClassFeature;
import de.linkvt.ontobench.features.classexpressions.OwlNothingFeature;
import de.linkvt.ontobench.features.classexpressions.OwlThingFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.cardinality.OwlObjectCardinalityOwlLiteFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.cardinality.OwlObjectMaxCardinalityOwlLiteAnd2RlFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.cardinality.OwlObjectMinCardinalityOwlLiteFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.value.OwlObjectAllValuesFromFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.value.OwlObjectSomeValuesFromFeature;
import de.linkvt.ontobench.features.individuals.assertions.OwlAllDifferentFeature;
import de.linkvt.ontobench.features.individuals.assertions.OwlSameAsFeature;

import org.springframework.stereotype.Component;

@Component
public class OwlLitePreset extends Preset {
  @Override
  protected void initialize() {
    addFeatures(OwlObjectCardinalityOwlLiteFeature.class, OwlObjectMaxCardinalityOwlLiteAnd2RlFeature.class, OwlObjectMinCardinalityOwlLiteFeature.class);
    addFeatures(OwlObjectAllValuesFromFeature.class, OwlObjectSomeValuesFromFeature.class);
    addFeatures(OwlClassFeature.class, OwlThingFeature.class, OwlNothingFeature.class);
    addFeatures(OwlEquivalentClassFeature.class);
    addFeatures(OwlDeprecatedClassFeature.class);

    addFeatures(OwlObjectPropertyFeature.class);
    addFeatures(RdfsObjectDomainFeature.class, RdfsObjectRangeFeature.class, UnboundObjectPropertyFeature.class);
    addFeatures(RdfsDataDomainFeature.class, RdfsDataRangeFeature.class, UnboundDataPropertyFeature.class);
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
