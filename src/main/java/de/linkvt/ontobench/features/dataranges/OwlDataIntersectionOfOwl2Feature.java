package de.linkvt.ontobench.features.dataranges;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataIntersectionOf;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataIntersectionOfOwl2Feature extends Feature {
  @Override
  public void addToOntology() {
    OWLDatatype d1 = OWL2Datatype.XSD_STRING.getDatatype(factory);
    OWLDatatype d2 = OWL2Datatype.XSD_DATE_TIME.getDatatype(factory);
    OWLDataIntersectionOf intersection = factory.getOWLDataIntersectionOf(d1, d2);

    OWLDataProperty property = factory.getOWLDataProperty(":datatypeIntersectionOfProperty_OWL2", pm);
    addToGenericDomainAndNewRange(property, intersection);
  }

  @Override
  public String getName() {
    return "owl:intersectionOf";
  }

  @Override
  public String getCompliance() {
    return "OWL 2";
  }

  @Override
  public String getToken() {
    return "intersectionofowl2data";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_RANGES;
  }
}
