package de.linkvt.bachelor.presets;

import de.linkvt.bachelor.features.annotations.OwlAnnotationPropertyFeature;
import de.linkvt.bachelor.features.annotations.OwlDeprecatedClassFeature;
import de.linkvt.bachelor.features.annotations.OwlDeprecatedPropertyFeature;
import de.linkvt.bachelor.features.axioms.classexpression.OwlAllDisjointClassesFeature;
import de.linkvt.bachelor.features.axioms.classexpression.OwlDisjointWithFeature;
import de.linkvt.bachelor.features.axioms.classexpression.OwlEquivalentClassFeature;
import de.linkvt.bachelor.features.axioms.classexpression.RdfsSubClassOfFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.OwlDatatypePropertyFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.OwlEquivalentDataPropertyFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.OwlFunctionalDataPropertyFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.RdfsDataDomainFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.RdfsDataRangeFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.RdfsDataSubPropertyOfFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.UnboundDataPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlEquivalentObjectPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlObjectPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlPropertyChainAxiomFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlReflexivePropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlTransitivePropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.RdfsObjectDomainFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.RdfsObjectRangeFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.RdfsObjectSubPropertyOfFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.UnboundObjectPropertyFeature;
import de.linkvt.bachelor.features.classexpressions.OwlClassFeature;
import de.linkvt.bachelor.features.classexpressions.OwlNothingFeature;
import de.linkvt.bachelor.features.classexpressions.OwlThingFeature;
import de.linkvt.bachelor.features.classexpressions.connectivesandenumeration.OwlObjectIntersectionOfFeature;
import de.linkvt.bachelor.features.classexpressions.connectivesandenumeration.OwlObjectOneOfOwl2ElFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.data.value.OwlDataHasValueFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.data.value.OwlDataSomeValuesFromFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.value.OwlHasSelfFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.value.OwlObjectHasValueFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.value.OwlObjectSomeValuesFromFeature;
import de.linkvt.bachelor.features.dataranges.OwlDataIntersectionOfOwl2Feature;
import de.linkvt.bachelor.features.dataranges.OwlDataOneOfOwl2ELFeature;
import de.linkvt.bachelor.features.dataranges.RdfsDatatypeFeature;
import de.linkvt.bachelor.features.individuals.NamedIndividualFeature;
import de.linkvt.bachelor.features.individuals.assertions.OwlAllDifferentFeature;
import de.linkvt.bachelor.features.individuals.assertions.OwlNegativeDataPropertyAssertionFeature;
import de.linkvt.bachelor.features.individuals.assertions.OwlNegativeObjectPropertyAssertionFeature;
import de.linkvt.bachelor.features.individuals.assertions.OwlSameAsFeature;
import de.linkvt.bachelor.features.keys.OwlHasKeyFeature;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class Owl2ElPreset extends Owl2Preset {
  @Override
  protected void initialize() {
    addFeatures(OwlObjectSomeValuesFromFeature.class, OwlDataSomeValuesFromFeature.class);
    addFeatures(OwlObjectHasValueFeature.class, OwlDataHasValueFeature.class);
    addFeatures(OwlHasSelfFeature.class);
    addFeatures(OwlObjectOneOfOwl2ElFeature.class);
    addFeatures(OwlDataOneOfOwl2ELFeature.class); // OWLApi marks this as a violation
    addFeatures(OwlObjectIntersectionOfFeature.class);
    addFeatures(OwlDataIntersectionOfOwl2Feature.class);

    addFeatures(RdfsSubClassOfFeature.class);
    addFeatures(OwlEquivalentClassFeature.class);
    addFeatures(OwlAllDisjointClassesFeature.class, OwlDisjointWithFeature.class);
    addFeatures(RdfsObjectSubPropertyOfFeature.class, RdfsDataSubPropertyOfFeature.class);
    addFeatures(OwlEquivalentObjectPropertyFeature.class, OwlEquivalentDataPropertyFeature.class);
    addFeatures(OwlTransitivePropertyFeature.class);
    addFeatures(OwlReflexivePropertyFeature.class);
    addFeatures(RdfsObjectDomainFeature.class, RdfsObjectRangeFeature.class, UnboundObjectPropertyFeature.class);
    addFeatures(RdfsDataDomainFeature.class, RdfsDataRangeFeature.class, UnboundDataPropertyFeature.class);
    addFeatures(OwlSameAsFeature.class, OwlAllDifferentFeature.class);
    addFeatures(OwlNegativeDataPropertyAssertionFeature.class, OwlNegativeObjectPropertyAssertionFeature.class);
    addFeatures(OwlFunctionalDataPropertyFeature.class);
    addFeatures(OwlHasKeyFeature.class);

    addFeatures(NamedIndividualFeature.class);
    addFeatures(OwlObjectPropertyFeature.class);
    addFeatures(OwlDatatypePropertyFeature.class);
    addFeatures(OwlClassFeature.class, OwlThingFeature.class, OwlNothingFeature.class);
    addFeatures(RdfsDatatypeFeature.class);

    addFeatures(OwlAnnotationPropertyFeature.class);
    addFeatures(OwlDeprecatedClassFeature.class, OwlDeprecatedPropertyFeature.class);
    addFeatures(OwlPropertyChainAxiomFeature.class);

    addCompatibleOwl2DatatypeFeatures(OWL2Datatype.EL_DATATYPES);
    // also possible
//    addFeatures(OwlVersionInfoFeature.class);
//    addFeatures(RdfsLabelOnOntologyFeature.class);
//    addFeatures(RdfsCommentOnOntologyFeature.class);
//    addFeatures(RdfsCommentMultiLanguageFeature.class);
//    addFeatures(RdfsLabelFeature.class);
//    addFeatures(RdfsLabelMultiLanguageFeature.class);
//    addFeatures(RdfsCommentFeature.class);
  }

  @Override
  public String getName() {
    return "OWL 2 EL";
  }

  @Override
  public int getIndex() {
    return 2;
  }
}
