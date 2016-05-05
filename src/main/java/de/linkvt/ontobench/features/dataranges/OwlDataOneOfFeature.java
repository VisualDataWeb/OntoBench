package de.linkvt.ontobench.features.dataranges;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.springframework.stereotype.Component;

@Component
public class OwlDataOneOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDatatype datatype = factory.getOWLDatatype(":DataOneOf", pm);

    OWLLiteral l1 = factory.getOWLLiteral("DataOneOf_Literal1");
    OWLLiteral l2 = factory.getOWLLiteral("DataOneOf_Literal2");
    OWLLiteral l3 = factory.getOWLLiteral("DataOneOf_Literal3");

    OWLDataOneOf owlDataOneOf = factory.getOWLDataOneOf(l1, l2, l3);
    addAxiomToOntology(factory.getOWLDatatypeDefinitionAxiom(datatype, owlDataOneOf));
  }

  @Override
  public String getName() {
    return "owl:oneOf";
  }

  @Override
  public String getToken() {
    return "oneofdata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_RANGES;
  }
}
