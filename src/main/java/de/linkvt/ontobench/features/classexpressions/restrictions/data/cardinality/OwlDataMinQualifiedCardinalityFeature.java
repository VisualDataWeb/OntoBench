package de.linkvt.ontobench.features.classexpressions.restrictions.data.cardinality;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataMinQualifiedCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty property = factory.getOWLDataProperty(":dataMinQualifiedCardinality", pm);
    OWLDatatype datatype = OWL2Datatype.XSD_FLOAT.getDatatype(factory);
    addToGenericDomainAndNewRange(property, datatype);

    OWLDatatype affectedDatatype = OWL2Datatype.XSD_DATE_TIME.getDatatype(factory);
    OWLDataMinCardinality cardinality = factory.getOWLDataMinCardinality(9, property, affectedDatatype);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(featurePool.getExclusiveClass(":DataMinQualifiedCardinalityRange"), cardinality));
  }

  @Override
  public String getName() {
    return "owl:minQualifiedCardinality";
  }

  @Override
  public String getToken() {
    return "minqualifiedcardinalitydata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTY_RESTRICTIONS;
  }
}
