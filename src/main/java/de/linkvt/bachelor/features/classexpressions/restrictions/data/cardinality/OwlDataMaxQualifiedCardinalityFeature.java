package de.linkvt.bachelor.features.classexpressions.restrictions.data.cardinality;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataMaxQualifiedCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty property = factory.getOWLDataProperty(":dataMaxQualifiedCardinality", pm);
    OWLDatatype datatype = OWL2Datatype.RDFS_LITERAL.getDatatype(factory);
    addToGenericDomainAndNewRange(property, datatype);

    OWLDatatype affectedDatatype = OWL2Datatype.XSD_BYTE.getDatatype(factory);
    OWLDataExactCardinality cardinality = factory.getOWLDataExactCardinality(18, property, affectedDatatype);
    OWLAxiom axiom = factory.getOWLSubClassOfAxiom(featurePool.getExclusiveClass(":DataMaxQualifiedCardinalityRange"), cardinality);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:maxQualifiedCardinality (Data Property)";
  }

  @Override
  public String getToken() {
    return "maxqualifiedcardinalitydata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTY_RESTRICTIONS;
  }
}
