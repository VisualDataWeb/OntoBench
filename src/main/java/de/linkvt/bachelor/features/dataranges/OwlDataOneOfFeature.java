package de.linkvt.bachelor.features.dataranges;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.springframework.stereotype.Component;

@Component
public class OwlDataOneOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDatatype datatype = factory.getOWLDatatype(":DataOneOf", pm);

    OWLLiteral zero = factory.getOWLLiteral(0);
    OWLLiteral fifteen = factory.getOWLLiteral(15);
    OWLLiteral thirty = factory.getOWLLiteral(30);
    OWLLiteral fourty = factory.getOWLLiteral(40);

    OWLDataOneOf owlDataOneOf = factory.getOWLDataOneOf(zero, fifteen, thirty, fourty);

    addAxiomToOntology(factory.getOWLDatatypeDefinitionAxiom(datatype, owlDataOneOf));
  }

  @Override
  public String getName() {
    return "owl:oneOf (Data Range)";
  }

  @Override
  public String getToken() {
    return "oneofdata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_RANGE_EXPRESSIONS;
  }
}
