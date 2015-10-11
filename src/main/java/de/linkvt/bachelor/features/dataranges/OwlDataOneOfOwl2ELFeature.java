package de.linkvt.bachelor.features.dataranges;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.springframework.stereotype.Component;

@Component
public class OwlDataOneOfOwl2ELFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDatatype datatype = factory.getOWLDatatype(":DataOneOf_EL", pm);
    OWLLiteral singleLiteral = factory.getOWLLiteral("DataOneOf_EL_Literal1");
    OWLDataOneOf owlDataOneOf = factory.getOWLDataOneOf(singleLiteral);

    addAxiomToOntology(factory.getOWLDatatypeDefinitionAxiom(datatype, owlDataOneOf));
  }

  @Override
  public String getName() {
    return "owl:oneOf (adjusted to OWL 2 EL)";
  }

  @Override
  public String getToken() {
    return "oneofsingledata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_RANGES;
  }
}
