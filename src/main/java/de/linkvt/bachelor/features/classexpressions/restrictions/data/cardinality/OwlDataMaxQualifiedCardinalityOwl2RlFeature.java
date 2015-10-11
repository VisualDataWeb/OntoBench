package de.linkvt.bachelor.features.classexpressions.restrictions.data.cardinality;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataMaxQualifiedCardinalityOwl2RlFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty property = factory.getOWLDataProperty(":dataMaxQualifiedCardinality_RL", pm);
    OWLDatatype datatype = OWL2Datatype.RDFS_LITERAL.getDatatype(factory);
    addToGenericDomainAndNewRange(property, datatype);

    OWLDatatype affectedDatatype = OWL2Datatype.XSD_BYTE.getDatatype(factory);
    OWLDataMaxCardinality cardinality = factory.getOWLDataMaxCardinality(1, property, affectedDatatype);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(featurePool.getExclusiveClass(":DataMaxQualifiedCardinalityRange_RL"), cardinality));
  }

  @Override
  public String getName() {
    return "owl:maxQualifiedCardinality (adjusted to OWL 2 RL)";
  }

  @Override
  public String getToken() {
    return "maxqualifiedrlcardinalitydata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTY_RESTRICTIONS;
  }
}
