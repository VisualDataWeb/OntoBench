package de.linkvt.bachelor.features.classexpressions.restrictions.data.cardinality;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataMaxCardinalityOwl2RlFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty property = factory.getOWLDataProperty(":dataMaxCardinality_RL", pm);
    OWLDatatype datatype = OWL2Datatype.XSD_FLOAT.getDatatype(factory);
    addToGenericDomainAndNewRange(property, datatype);

    OWLClass range = featurePool.getExclusiveClass(":DataMaxCardinalityRange_RL");
    OWLDataMaxCardinality cardinality = factory.getOWLDataMaxCardinality(1, property);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, cardinality));
  }

  @Override
  public String getName() {
    return "owl:maxCardinality";
  }

  @Override
  public String getCompliance() {
    return "OWL 2 RL";
  }

  @Override
  public String getToken() {
    return "maxcardinalityrldata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTY_RESTRICTIONS;
  }
}
