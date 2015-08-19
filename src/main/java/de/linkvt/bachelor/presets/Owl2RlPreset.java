package de.linkvt.bachelor.presets;

import de.linkvt.bachelor.features.annotations.OwlDeprecatedClassFeature;
import de.linkvt.bachelor.features.annotations.OwlDeprecatedPropertyFeature;
import de.linkvt.bachelor.features.assertions.OwlAllDifferentFeature;
import de.linkvt.bachelor.features.assertions.OwlSameAsFeature;
import de.linkvt.bachelor.features.axioms.classexpression.OwlEquivalentClassFeature;
import de.linkvt.bachelor.features.axioms.classexpression.RdfsSubClassOfFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.OwlFunctionalDataPropertyFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.RdfsDataDomainFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.RdfsDataRangeFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.RdfsDataSubPropertyOfFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlAllDisjointObjectPropertiesFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlAsymmetricPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlEquivalentObjectPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlFunctionalObjectPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlInverseFunctionalPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlInverseOfPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlIrreflexivePropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlObjectPropertyDisjointWithFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlPropertyChainAxiomFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlSymmetricPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlTransitivePropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.RdfsObjectDomainFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.RdfsObjectRangeFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.RdfsObjectSubPropertyOfFeature;
import de.linkvt.bachelor.features.classexpressions.connectivesandenumeration.OwlObjectComplementOfFeature;
import de.linkvt.bachelor.features.classexpressions.connectivesandenumeration.OwlObjectIntersectionOfFeature;
import de.linkvt.bachelor.features.classexpressions.connectivesandenumeration.OwlObjectOneOfOwl2RlFeature;
import de.linkvt.bachelor.features.classexpressions.connectivesandenumeration.OwlObjectUnionOfOwl2RlFeature;
import de.linkvt.bachelor.features.classexpressions.predefinedandnamed.OwlNothingFeature;
import de.linkvt.bachelor.features.classexpressions.predefinedandnamed.OwlThingFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.data.cardinality.OwlDataMaxCardinalityOwl2RlFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.data.cardinality.OwlDataMaxQualifiedCardinalityOwl2RlFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.data.value.OwlDataAllValuesFromFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.data.value.OwlDataHasValueFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.data.value.OwlDataSomeValuesFromOwl2RlFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.cardinality.OwlObjectMaxCardinalityOwlLiteAnd2RlFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.cardinality.OwlObjectMaxQualifiedCardinalityOwl2RlFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.value.OwlObjectAllValuesFromFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.value.OwlObjectHasValueFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.value.OwlObjectSomeValuesFromOwl2RlFeature;
import de.linkvt.bachelor.features.declarations.NamedIndividualFeature;
import de.linkvt.bachelor.features.declarations.OwlAnnotationPropertyFeature;
import de.linkvt.bachelor.features.declarations.OwlClassFeature;
import de.linkvt.bachelor.features.declarations.OwlDatatypePropertyFeature;
import de.linkvt.bachelor.features.declarations.OwlObjectPropertyFeature;
import de.linkvt.bachelor.features.declarations.RdfsDatatypeFeature;
import de.linkvt.bachelor.features.declarations.UnboundDataPropertyFeature;
import de.linkvt.bachelor.features.declarations.UnboundObjectPropertyFeature;
import de.linkvt.bachelor.features.individuals.AnonymousIndividualFeature;
import de.linkvt.bachelor.features.keys.OwlHasKeyFeature;
import de.linkvt.bachelor.features.visualization.MultipleLinksFeature;
import de.linkvt.bachelor.features.visualization.MultipleSymmetricPropertiesFeature;

import org.springframework.stereotype.Component;

@Component
public class Owl2RlPreset extends Preset {
  @Override
  protected void initialize() {
    addFeatures(AnonymousIndividualFeature.class);
    addFeatures(MultipleLinksFeature.class);
    addFeatures(MultipleSymmetricPropertiesFeature.class);
    addFeatures(NamedIndividualFeature.class);
    addFeatures(OwlAllDifferentFeature.class);
//    addFeatures(OwlAllDisjointClassesFeature.class); // TODO laut Spec. eigentlich erlaubt
//    addFeatures(OwlAllDisjointDataPropertiesFeature.class); // TODO laut Spec. eigentlich erlaubt
    addFeatures(OwlAllDisjointObjectPropertiesFeature.class);
    addFeatures(OwlAnnotationPropertyFeature.class);
    addFeatures(OwlAsymmetricPropertyFeature.class);
    addFeatures(OwlClassFeature.class);
    addFeatures(OwlDataAllValuesFromFeature.class);
//    addFeatures(OwlDataComplementOfFeature.class); // TODO unklar ob erlaubt (nichts angegeben)
    addFeatures(OwlDataHasValueFeature.class);
//    addFeatures(OwlDataIntersectionOfFeature.class); // TODO stimmt mMn, IllegalDataRange
    addFeatures(OwlDataMaxCardinalityOwl2RlFeature.class);
    addFeatures(OwlDataMaxQualifiedCardinalityOwl2RlFeature.class);
//    addFeatures(OwlDataOneOfFeature.class); // TODO unklar ob erlaubt (nichts angegeben)
//    addFeatures(OwlDataOneOfOwl2Feature.class); // TODO unklar ob erlaubt (nichts angegeben)
//    addFeatures(OwlDataPropertyDisjointWithFeature.class); // TODO laut Spec. eigentlich erlaubt
    addFeatures(OwlDataSomeValuesFromOwl2RlFeature.class);
//    addFeatures(OwlDataUnionOfFeature.class); // TODO unklar ob erlaubt (nichts angegeben)
    addFeatures(OwlDatatypePropertyFeature.class);
    addFeatures(OwlDeprecatedClassFeature.class);
    addFeatures(OwlDeprecatedPropertyFeature.class);
//    addFeatures(OwlDisjointWithFeature.class); // TODO laut Spec. eigentlich erlaubt
    addFeatures(OwlEquivalentClassFeature.class);
//    addFeatures(OwlEquivalentDataPropertyFeature.class); // TODO laut Spec. eigentlich erlaubt
    addFeatures(OwlEquivalentObjectPropertyFeature.class);
    addFeatures(OwlFunctionalDataPropertyFeature.class);
    addFeatures(OwlFunctionalObjectPropertyFeature.class);
    addFeatures(OwlHasKeyFeature.class);
//    addFeatures(OwlHasSelfFeature.class); // TODO unklar ob erlaubt (nichts angegeben, OWLAPI meckert aber nicht)
    addFeatures(OwlInverseFunctionalPropertyFeature.class);
    addFeatures(OwlInverseOfPropertyFeature.class);
    addFeatures(OwlIrreflexivePropertyFeature.class);
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
