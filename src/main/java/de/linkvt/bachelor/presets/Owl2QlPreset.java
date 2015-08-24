package de.linkvt.bachelor.presets;

import de.linkvt.bachelor.features.annotations.OwlDeprecatedClassFeature;
import de.linkvt.bachelor.features.annotations.OwlDeprecatedPropertyFeature;
import de.linkvt.bachelor.features.assertions.OwlAllDifferentFeature;
import de.linkvt.bachelor.features.axioms.classexpression.OwlAllDisjointClassesFeature;
import de.linkvt.bachelor.features.axioms.classexpression.OwlDisjointWithFeature;
import de.linkvt.bachelor.features.axioms.classexpression.OwlEquivalentClassFeature;
import de.linkvt.bachelor.features.axioms.classexpression.RdfsSubClassOfFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.OwlAllDisjointDataPropertiesFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.OwlDataPropertyDisjointWithFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.OwlEquivalentDataPropertyFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.RdfsDataDomainFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.RdfsDataRangeFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.RdfsDataSubPropertyOfFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlAllDisjointObjectPropertiesFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlAsymmetricPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlEquivalentObjectPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlInverseOfPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlIrreflexivePropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlObjectPropertyDisjointWithFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlReflexivePropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlSymmetricPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.RdfsObjectDomainFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.RdfsObjectRangeFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.RdfsObjectSubPropertyOfFeature;
import de.linkvt.bachelor.features.classexpressions.connectivesandenumeration.OwlObjectComplementOfFeature;
import de.linkvt.bachelor.features.classexpressions.connectivesandenumeration.OwlObjectIntersectionOfOwl2QlFeature;
import de.linkvt.bachelor.features.classexpressions.predefinedandnamed.OwlNothingFeature;
import de.linkvt.bachelor.features.classexpressions.predefinedandnamed.OwlThingFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.data.value.OwlDataSomeValuesFromFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.value.OwlObjectSomeValuesFromFeature;
import de.linkvt.bachelor.features.dataranges.OwlDataIntersectionOfOwl2Feature;
import de.linkvt.bachelor.features.declarations.NamedIndividualFeature;
import de.linkvt.bachelor.features.declarations.OwlAnnotationPropertyFeature;
import de.linkvt.bachelor.features.declarations.OwlClassFeature;
import de.linkvt.bachelor.features.declarations.OwlDatatypePropertyFeature;
import de.linkvt.bachelor.features.declarations.OwlObjectPropertyFeature;
import de.linkvt.bachelor.features.declarations.RdfsDatatypeFeature;

import org.springframework.stereotype.Component;

@Component
public class Owl2QlPreset extends Preset {
  @Override
  protected void initialize() {
    addFeatures(NamedIndividualFeature.class);
    addFeatures(OwlAllDifferentFeature.class);
    addFeatures(OwlAllDisjointClassesFeature.class); // OWLApi marks this as a violation
    addFeatures(OwlAllDisjointDataPropertiesFeature.class);
    addFeatures(OwlAllDisjointObjectPropertiesFeature.class);
    addFeatures(OwlAnnotationPropertyFeature.class);
    addFeatures(OwlAsymmetricPropertyFeature.class);
    addFeatures(OwlClassFeature.class);
    addFeatures(OwlDataIntersectionOfOwl2Feature.class);
    addFeatures(OwlDataPropertyDisjointWithFeature.class);
    addFeatures(OwlDataSomeValuesFromFeature.class);
    addFeatures(OwlDatatypePropertyFeature.class);
    addFeatures(OwlDeprecatedClassFeature.class);
    addFeatures(OwlDeprecatedPropertyFeature.class);
    addFeatures(OwlDisjointWithFeature.class); // OWLApi marks this as a violation
    addFeatures(OwlEquivalentClassFeature.class);
    addFeatures(OwlEquivalentDataPropertyFeature.class);
    addFeatures(OwlEquivalentObjectPropertyFeature.class);
    addFeatures(OwlInverseOfPropertyFeature.class);
    addFeatures(OwlIrreflexivePropertyFeature.class); // OWLApi marks this as a violation
    addFeatures(OwlNothingFeature.class);
    addFeatures(OwlObjectComplementOfFeature.class);
    addFeatures(OwlObjectIntersectionOfOwl2QlFeature.class);
    addFeatures(OwlObjectPropertyDisjointWithFeature.class);
    addFeatures(OwlObjectPropertyFeature.class);
    addFeatures(OwlObjectSomeValuesFromFeature.class);
    addFeatures(OwlReflexivePropertyFeature.class);
    addFeatures(OwlSymmetricPropertyFeature.class);
    addFeatures(OwlThingFeature.class);
    addFeatures(RdfsDataDomainFeature.class);
    addFeatures(RdfsDataRangeFeature.class);
    addFeatures(RdfsDataSubPropertyOfFeature.class);
    addFeatures(RdfsDatatypeFeature.class);
    addFeatures(RdfsObjectDomainFeature.class);
    addFeatures(RdfsObjectRangeFeature.class);
    addFeatures(RdfsObjectSubPropertyOfFeature.class);
    addFeatures(RdfsSubClassOfFeature.class);

    // also possible
//    addFeatures(OwlVersionInfoFeature.class);
//    addFeatures(RdfsCommentFeature.class);
//    addFeatures(RdfsCommentMultiLanguageFeature.class);
//    addFeatures(RdfsCommentOnOntologyFeature.class);
//    addFeatures(RdfsLabelFeature.class);
//    addFeatures(RdfsLabelMultiLanguageFeature.class);
//    addFeatures(RdfsLabelOnOntologyFeature.class);
//    addFeatures(UnboundDataPropertyFeature.class);
//    addFeatures(UnboundObjectPropertyFeature.class);
  }

  @Override
  public String getName() {
    return "OWL 2 QL";
  }

  @Override
  public int getIndex() {
    return 3;
  }
}
