package de.linkvt.bachelor.presets;

import de.linkvt.bachelor.features.axioms.classexpression.OwlAllDisjointClassesFeature;
import de.linkvt.bachelor.features.axioms.classexpression.OwlDisjointUnionFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.OwlAllDisjointDataPropertiesFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.OwlDataPropertyDisjointWithFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.OwlEquivalentDataPropertyFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.OwlFunctionalDataPropertyFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.RdfsDataDomainFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.RdfsDataRangeFeature;
import de.linkvt.bachelor.features.axioms.dataproperty.RdfsDataSubPropertyOfFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlAllDisjointObjectPropertiesFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlAsymmetricPropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlIrreflexivePropertyFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlObjectPropertyDisjointWithFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlPropertyChainAxiomFeature;
import de.linkvt.bachelor.features.axioms.objectproperty.OwlReflexivePropertyFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.data.cardinality.OwlDataCardinalityFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.data.cardinality.OwlDataMaxCardinalityFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.data.cardinality.OwlDataMaxQualifiedCardinalityFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.data.cardinality.OwlDataMinCardinalityFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.data.cardinality.OwlDataMinQualifiedCardinalityFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.data.cardinality.OwlDataQualifiedCardinalityFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.data.value.OwlDataAllValuesFromFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.data.value.OwlDataHasValueFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.data.value.OwlDataSomeValuesFromFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.cardinality.OwlObjectMaxQualifiedCardinalityFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.cardinality.OwlObjectMinQualifiedCardinalityFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.cardinality.OwlObjectQualifiedCardinalityFeature;
import de.linkvt.bachelor.features.classexpressions.restrictions.object.value.OwlHasSelfFeature;
import de.linkvt.bachelor.features.dataranges.OwlDataComplementOfFeature;
import de.linkvt.bachelor.features.dataranges.OwlDataIntersectionOfFeature;
import de.linkvt.bachelor.features.dataranges.OwlDataUnionOfFeature;

import org.springframework.stereotype.Component;

@Component
public class Owl2Preset extends Preset {
  @Override
  protected void initialize() {
    addFeatures(OwlHasSelfFeature.class);
    addFeatures(OwlDataAllValuesFromFeature.class, OwlDataSomeValuesFromFeature.class, OwlDataHasValueFeature.class);
    addFeatures(OwlObjectQualifiedCardinalityFeature.class, OwlObjectMinQualifiedCardinalityFeature.class, OwlObjectMaxQualifiedCardinalityFeature.class);
    addFeatures(OwlDataCardinalityFeature.class, OwlDataMinCardinalityFeature.class, OwlDataMaxCardinalityFeature.class);
    addFeatures(OwlDataQualifiedCardinalityFeature.class, OwlDataMinQualifiedCardinalityFeature.class, OwlDataMaxQualifiedCardinalityFeature.class);
    addFeatures(OwlDataUnionOfFeature.class, OwlDataIntersectionOfFeature.class, OwlDataComplementOfFeature.class);
    addFeatures(OwlAllDisjointClassesFeature.class);
    addFeatures(OwlDisjointUnionFeature.class);
    addFeatures(OwlPropertyChainAxiomFeature.class, OwlObjectPropertyDisjointWithFeature.class, OwlAllDisjointObjectPropertiesFeature.class);
    addFeatures(OwlReflexivePropertyFeature.class, OwlIrreflexivePropertyFeature.class, OwlAsymmetricPropertyFeature.class);
    addFeatures(OwlFunctionalDataPropertyFeature.class, OwlDataPropertyDisjointWithFeature.class, OwlAllDisjointDataPropertiesFeature.class, OwlEquivalentDataPropertyFeature.class);
    addFeatures(RdfsDataDomainFeature.class, RdfsDataRangeFeature.class, RdfsDataSubPropertyOfFeature.class);
  }

  @Override
  public String getName() {
    return "OWL 2 (WIP)";
  }

  @Override
  public int getIndex() {
    return 2;
  }
}
