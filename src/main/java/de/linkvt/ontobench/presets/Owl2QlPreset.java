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
import de.linkvt.ontobench.features.axioms.dataproperty.RdfsDataDomainFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.RdfsDataRangeFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.RdfsDataSubPropertyOfFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlAllDisjointObjectPropertiesFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlAsymmetricPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlEquivalentObjectPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlInverseOfPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlIrreflexivePropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlObjectPropertyDisjointWithFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlObjectPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlReflexivePropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlSymmetricPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.RdfsObjectDomainFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.RdfsObjectRangeFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.RdfsObjectSubPropertyOfFeature;
import de.linkvt.ontobench.features.classexpressions.OwlClassFeature;
import de.linkvt.ontobench.features.classexpressions.OwlNothingFeature;
import de.linkvt.ontobench.features.classexpressions.OwlThingFeature;
import de.linkvt.ontobench.features.classexpressions.connectivesandenumeration.OwlObjectComplementOfFeature;
import de.linkvt.ontobench.features.classexpressions.connectivesandenumeration.OwlObjectIntersectionOfOwl2QlFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.data.value.OwlDataSomeValuesFromFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.value.OwlObjectSomeValuesFromFeature;
import de.linkvt.ontobench.features.dataranges.OwlDataIntersectionOfOwl2Feature;
import de.linkvt.ontobench.features.dataranges.RdfsDatatypeFeature;
import de.linkvt.ontobench.features.individuals.NamedIndividualFeature;
import de.linkvt.ontobench.features.individuals.assertions.OwlAllDifferentFeature;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class Owl2QlPreset extends Owl2Preset {
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

    // the datatypes of OWL 2 EL and OWL 2 QL are equal
    addCompatibleOwl2DatatypeFeatures(OWL2Datatype.EL_DATATYPES);

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
