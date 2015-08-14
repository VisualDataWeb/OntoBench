package de.linkvt.bachelor.features.classexpressions.restrictions.data.cardinality;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
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
    OWLDataProperty property = factory.getOWLDataProperty(IRI.create(":dataExactCardinality"));
    OWLDatatype datatype = OWL2Datatype.XSD_STRING.getDatatype(factory);
    addToGenericDomainAndNewRange(property, datatype);

    OWLClass range = featurePool.getExclusiveClass(":DataExactCardinalityRange");
    OWLDataExactCardinality cardinality = factory.getOWLDataExactCardinality(11, property);
    OWLAxiom axiom = factory.getOWLSubClassOfAxiom(range, cardinality);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:cardinality (Data Property)";
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
