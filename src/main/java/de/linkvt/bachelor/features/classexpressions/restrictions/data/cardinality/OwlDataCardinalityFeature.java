package de.linkvt.bachelor.features.classexpressions.restrictions.data.cardinality;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty property = factory.getOWLDataProperty(":dataExactCardinality", pm);
    OWLDatatype datatype = OWL2Datatype.XSD_STRING.getDatatype(factory);
    addToGenericDomainAndNewRange(property, datatype);

    OWLClass range = featurePool.getExclusiveClass(":DataExactCardinalityRange");
    OWLDataExactCardinality cardinality = factory.getOWLDataExactCardinality(11, property);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, cardinality));
  }

  @Override
  public String getName() {
    return "owl:cardinality";
  }

  @Override
  public String getToken() {
    return "cardinalitydata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTY_RESTRICTIONS;
  }
}
