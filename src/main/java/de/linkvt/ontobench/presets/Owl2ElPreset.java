package de.linkvt.ontobench.presets;

import de.linkvt.ontobench.features.annotations.OwlAnnotationPropertyFeature;
import de.linkvt.ontobench.features.annotations.OwlDeprecatedClassFeature;
import de.linkvt.ontobench.features.annotations.OwlDeprecatedPropertyFeature;
import de.linkvt.ontobench.features.axioms.classexpression.OwlAllDisjointClassesFeature;
import de.linkvt.ontobench.features.axioms.classexpression.OwlDisjointWithFeature;
import de.linkvt.ontobench.features.axioms.classexpression.OwlEquivalentClassFeature;
import de.linkvt.ontobench.features.axioms.classexpression.RdfsSubClassOfFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.OwlDatatypePropertyFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.OwlEquivalentDataPropertyFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.OwlFunctionalDataPropertyFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.RdfsDataDomainFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.RdfsDataRangeFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.RdfsDataSubPropertyOfFeature;
import de.linkvt.ontobench.features.axioms.dataproperty.UnboundDataPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlEquivalentObjectPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlObjectPropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlPropertyChainAxiomFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlReflexivePropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.OwlTransitivePropertyFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.RdfsObjectDomainFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.RdfsObjectRangeFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.RdfsObjectSubPropertyOfFeature;
import de.linkvt.ontobench.features.axioms.objectproperty.UnboundObjectPropertyFeature;
import de.linkvt.ontobench.features.classexpressions.OwlClassFeature;
import de.linkvt.ontobench.features.classexpressions.OwlNothingFeature;
import de.linkvt.ontobench.features.classexpressions.OwlThingFeature;
import de.linkvt.ontobench.features.classexpressions.connectivesandenumeration.OwlObjectIntersectionOfFeature;
import de.linkvt.ontobench.features.classexpressions.connectivesandenumeration.OwlObjectOneOfOwl2ElFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.data.value.OwlDataHasValueFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.data.value.OwlDataSomeValuesFromFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.value.OwlHasSelfFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.value.OwlObjectHasValueFeature;
import de.linkvt.ontobench.features.classexpressions.restrictions.object.value.OwlObjectSomeValuesFromFeature;
import de.linkvt.ontobench.features.dataranges.OwlDataIntersectionOfOwl2Feature;
import de.linkvt.ontobench.features.dataranges.OwlDataOneOfOwl2ELFeature;
import de.linkvt.ontobench.features.dataranges.RdfsDatatypeFeature;
import de.linkvt.ontobench.features.individuals.NamedIndividualFeature;
import de.linkvt.ontobench.features.individuals.assertions.OwlAllDifferentFeature;
import de.linkvt.ontobench.features.individuals.assertions.OwlNegativeDataPropertyAssertionFeature;
import de.linkvt.ontobench.features.individuals.assertions.OwlNegativeObjectPropertyAssertionFeature;
import de.linkvt.ontobench.features.individuals.assertions.OwlSameAsFeature;
import de.linkvt.ontobench.features.keys.OwlHasKeyFeature;

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
