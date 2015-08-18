package de.linkvt.bachelor.features.classexpressions.restrictions.data.cardinality;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataMinCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty property = factory.getOWLDataProperty(":dataMinCardinality", pm);
    OWLDatatype datatype = OWL2Datatype.XSD_BOOLEAN.getDatatype(factory);
    addToGenericDomainAndNewRange(property, datatype);

    OWLClass range = featurePool.getExclusiveClass(":DataMinCardinalityRange");
    OWLDataMinCardinality cardinality = factory.getOWLDataMinCardinality(3, property);
    OWLAxiom axiom = factory.getOWLSubClassOfAxiom(range, cardinality);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:minCardinality (Data Property)";
  }

  @Override
  public String getToken() {
    return "mincardinalitydata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTY_RESTRICTIONS;
  }
}
