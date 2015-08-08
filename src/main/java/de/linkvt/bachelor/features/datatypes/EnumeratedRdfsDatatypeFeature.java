package de.linkvt.bachelor.features.datatypes;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.springframework.stereotype.Component;

@Component
public class EnumeratedRdfsDatatypeFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDatatype datatype = factory.getOWLDatatype(IRI.create("TennisGameScore"));

    OWLLiteral zero = factory.getOWLLiteral(0);
    OWLLiteral fifteen = factory.getOWLLiteral(15);
    OWLLiteral thirty = factory.getOWLLiteral(30);
    OWLLiteral fourty = factory.getOWLLiteral(40);

    OWLDataOneOf owlDataOneOf = factory.getOWLDataOneOf(zero, fifteen, thirty, fourty);

    addAxiomToOntology(factory.getOWLDatatypeDefinitionAxiom(datatype, owlDataOneOf));
  }

  @Override
  public String getName() {
    return "rdfs:Datatype (enumerated)";
  }

  @Override
  public String getToken() {
    return "enumerateddatatype";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATATYPE;
  }
}
