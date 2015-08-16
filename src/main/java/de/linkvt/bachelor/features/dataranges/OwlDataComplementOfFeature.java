package de.linkvt.bachelor.features.dataranges;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataComplementOf;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataComplementOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDatatype datatype = OWL2Datatype.XSD_STRING.getDatatype(factory);
    OWLDataComplementOf complement = factory.getOWLDataComplementOf(datatype);

    addToGenericDomainAndNewRange(factory.getOWLDataProperty(":complementOfString", pm), complement);
  }

  @Override
  public String getName() {
    return "owl:complementOf (Data Range)";
  }

  @Override
  public String getToken() {
    return "complementdata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_RANGE_EXPRESSIONS;
  }
}
