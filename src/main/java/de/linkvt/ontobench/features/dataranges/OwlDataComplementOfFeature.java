package de.linkvt.ontobench.features.dataranges;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

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

    addToGenericDomainAndNewRange(factory.getOWLDataProperty(":dataComplementOfProperty", pm), complement);
  }

  @Override
  public String getName() {
    return "owl:complementOf";
  }

  @Override
  public String getToken() {
    return "complementdata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_RANGES;
  }
}
