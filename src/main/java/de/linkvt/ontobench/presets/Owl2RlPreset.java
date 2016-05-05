package de.linkvt.ontobench.presets;

import de.linkvt.ontobench.features.annotations.OwlAnnotationPropertyFeature;
import de.linkvt.ontobench.features.annotations.OwlDeprecatedClassFeature;
import de.linkvt.ontobench.features.annotations.OwlDeprecatedPropertyFeature;
import de.linkvt.ontobench.features.axioms.classexpression.OwlAllDisjointClassesFeature;
import de.linkvt.ontobench.features.axioms.classexpression.OwlDisjointWithFeature;
import de.linkvt.ontobench.features.axioms.classexpression.OwlEquivalentClassFeature;
import de.linkvt.ontobench.features.axioms.classexpression.RdfsSubClassOfFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.OwlAllDisjointDataPropertiesFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.OwlDataPropertyDisjointWithFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.OwlDatatypePropertyFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.OwlEquivalentDataPropertyFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.OwlFunctionalDataPropertyFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.RdfsDataDomainFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.RdfsDataRangeFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.RdfsDataSubPropertyOfFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.UnboundDataPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlAllDisjointObjectPropertiesFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlAsymmetricPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlEquivalentObjectPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlFunctionalObjectPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlInverseFunctionalPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlInverseOfPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlIrreflexivePropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlObjectPropertyDisjointWithFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlObjectPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlPropertyChainAxiomFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlSymmetricPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlTransitivePropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.RdfsObjectDomainFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.RdfsObjectRangeFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.RdfsObjectSubPropertyOfFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.UnboundObjectPropertyFeature;
import de.linkvt.ontobench.features.classexpressions.OwlClassFeature;
import de.linkvt.ontobench.features.classexpressions.OwlNothingFeature;
import de.linkvt.ontobench.features.classexpressions.OwlThingFeature;
import de.linkvt.ontobench.features.classexpressions.connectivesandenumeration.OwlObjectComplementOfFeature;
import de.linkvt.ontobench.features.classexpressions.connectivesandenumeration.OwlObjectIntersectionOfFeature;
import de.linkvt.ontobench.features.classexpressions.connectivesandenumeration.OwlObjectOneOfOwl2RlFeature;
import de.linkvt.ontobench.features.classexpressions.connectivesandenumeration.OwlObjectUnionOfOwl2RlFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.data.cardinality.OwlDataMaxCardinalityOwl2RlFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.data.cardinality.OwlDataMaxQualifiedCardinalityOwl2RlFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.data.value.OwlDataAllValuesFromFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.data.value.OwlDataHasValueFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.data.value.OwlDataSomeValuesFromOwl2RlFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.cardinality.OwlObjectMaxCardinalityOwlLiteAnd2RlFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.cardinality.OwlObjectMaxQualifiedCardinalityOwl2RlFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.value.OwlObjectAllValuesFromFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.value.OwlObjectHasValueFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.value.OwlObjectSomeValuesFromOwl2RlFeature;
import de.linkvt.ontobench.features.dataranges.OwlDataIntersectionOfOwl2Feature;
import de.linkvt.ontobench.features.dataranges.RdfsDatatypeFeature;
import de.linkvt.ontobench.features.individuals.AnonymousIndividualFeature;
import de.linkvt.ontobench.features.individuals.NamedIndividualFeature;
import de.linkvt.ontobench.features.individuals.assertions.OwlAllDifferentFeature;
import de.linkvt.ontobench.features.individuals.assertions.OwlNegativeDataPropertyAssertionFeature;
import de.linkvt.ontobench.features.individuals.assertions.OwlNegativeObjectPropertyAssertionFeature;
import de.linkvt.ontobench.features.individuals.assertions.OwlSameAsFeature;
import de.linkvt.ontobench.features.keys.OwlHasKeyFeature;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class Owl2RlPreset extends Owl2Preset {
  @Override
  protected void initialize() {
    addFeatures(AnonymousIndividualFeature.class);
    addFeatures(NamedIndividualFeature.class);
    addFeatures(OwlAllDifferentFeature.class);
    addFeatures(OwlAllDisjointClassesFeature.class); // OWLApi marks this as a violation
    addFeatures(OwlAllDisjointDataPropertiesFeature.class); // OWLApi marks this as a violation
    addFeatures(OwlAllDisjointObjectPropertiesFeature.class);
    addFeatures(OwlAnnotationPropertyFeature.class);
    addFeatures(OwlAsymmetricPropertyFeature.class);
    addFeatures(OwlClassFeature.class);
    addFeatures(OwlDataAllValuesFromFeature.class);
    addFeatures(OwlDataHasValueFeature.class);
    addFeatures(OwlDataIntersectionOfOwl2Feature.class);
    addFeatures(OwlDataMaxCardinalityOwl2RlFeature.class);
    addFeatures(OwlDataMaxQualifiedCardinalityOwl2RlFeature.class);
    addFeatures(OwlDataPropertyDisjointWithFeature.class); // OWLApi marks this as a violation
    addFeatures(OwlDataSomeValuesFromOwl2RlFeature.class);
    addFeatures(OwlDatatypePropertyFeature.class);
    addFeatures(OwlDeprecatedClassFeature.class);
    addFeatures(OwlDeprecatedPropertyFeature.class);
    addFeatures(OwlDisjointWithFeature.class); // OWLApi marks this as a violation
    addFeatures(OwlEquivalentClassFeature.class);
    addFeatures(OwlEquivalentDataPropertyFeature.class); // OWLApi marks this as a violation
    addFeatures(OwlEquivalentObjectPropertyFeature.class);
    addFeatures(OwlFunctionalDataPropertyFeature.class);
    addFeatures(OwlFunctionalObjectPropertyFeature.class);
    addFeatures(OwlHasKeyFeature.class);
    addFeatures(OwlInverseFunctionalPropertyFeature.class);
    addFeatures(OwlInverseOfPropertyFeature.class);
    addFeatures(OwlIrreflexivePropertyFeature.class);
    addFeatures(OwlNegativeDataPropertyAssertionFeature.class);
    addFeatures(OwlNegativeObjectPropertyAssertionFeature.class);
    addFeatures(OwlNothingFeature.class);
    addFeatures(OwlObjectAllValuesFromFeature.class);
    addFeatures(OwlObjectComplementOfFeature.class);
    addFeatures(OwlObjectHasValueFeature.class);
    addFeatures(OwlObjectIntersectionOfFeature.class);
    addFeatures(OwlObjectMaxCardinalityOwlLiteAnd2RlFeature.class);
    addFeatures(OwlObjectMaxQualifiedCardinalityOwl2RlFeature.class);
    addFeatures(OwlObjectOneOfOwl2RlFeature.class);
    addFeatures(OwlObjectPropertyDisjointWithFeature.class);
    addFeatures(OwlObjectPropertyFeature.class);
    addFeatures(OwlObjectSomeValuesFromOwl2RlFeature.class);
    addFeatures(OwlObjectUnionOfOwl2RlFeature.class);
    addFeatures(OwlPropertyChainAxiomFeature.class);
    addFeatures(OwlSameAsFeature.class);
    addFeatures(OwlSymmetricPropertyFeature.class);
    addFeatures(OwlThingFeature.class);
    addFeatures(OwlTransitivePropertyFeature.class);
    addFeatures(RdfsDataDomainFeature.class);
    addFeatures(RdfsDataRangeFeature.class);
    addFeatures(RdfsDataSubPropertyOfFeature.class);
    addFeatures(RdfsDatatypeFeature.class);
    addFeatures(RdfsObjectDomainFeature.class);
    addFeatures(RdfsObjectRangeFeature.class);
    addFeatures(RdfsObjectSubPropertyOfFeature.class);
    addFeatures(RdfsSubClassOfFeature.class);
    addFeatures(UnboundDataPropertyFeature.class);
    addFeatures(UnboundObjectPropertyFeature.class);

    addCompatibleOwl2DatatypeFeatures(OWL2Datatype.RL_DATATYPES);
    // also possible
//    addFeatures(OwlVersionInfoFeature.class);
//    addFeatures(RdfsCommentFeature.class);
//    addFeatures(RdfsCommentMultiLanguageFeature.class);
//    addFeatures(RdfsCommentOnOntologyFeature.class);
//    addFeatures(RdfsLabelFeature.class);
//    addFeatures(RdfsLabelMultiLanguageFeature.class);
//    addFeatures(RdfsLabelOnOntologyFeature.class);
  }

  @Override
  public String getName() {
    return "OWL 2 RL";
  }

  @Override
  public int getIndex() {
    return 4;
  }
}
