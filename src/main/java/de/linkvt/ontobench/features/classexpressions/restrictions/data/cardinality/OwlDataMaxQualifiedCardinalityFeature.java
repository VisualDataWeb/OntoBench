package de.linkvt.ontobench.features.classexpressions.restrictions.data.cardinality;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
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
    OWLDataMaxCardinality cardinality = factory.getOWLDataMaxCardinality(18, property, affectedDatatype);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(featurePool.getExclusiveClass(":DataMaxQualifiedCardinalityRange"), cardinality));
  }

  @Override
  public String getName() {
    return "owl:maxQualifiedCardinality";
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
