package de.linkvt.bachelor.features.classexpressions.restrictions.data.cardinality;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataQualifiedCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty property = factory.getOWLDataProperty(":dataExactQualifiedCardinality", pm);
    OWLDatatype datatype = OWL2Datatype.XSD_STRING.getDatatype(factory);
    addToGenericDomainAndNewRange(property, datatype);

    OWLDatatype affectedDatatype = OWL2Datatype.XSD_DATE_TIME.getDatatype(factory);
    OWLDataExactCardinality cardinality = factory.getOWLDataExactCardinality(12, property, affectedDatatype);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(featurePool.getExclusiveClass(":DataExactQualifiedCardinalityRange"), cardinality));
  }

  @Override
  public String getName() {
    return "owl:qualifiedCardinality";
  }

  @Override
  public String getToken() {
    return "qualifiedcardinalitydata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTY_RESTRICTIONS;
  }
}
