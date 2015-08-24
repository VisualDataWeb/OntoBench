package de.linkvt.bachelor.features.dataranges;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataIntersectionOf;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataIntersectionOfOwl2Feature extends Feature {
  @Override
  public void addToOntology() {
    OWLDatatype first = OWL2Datatype.XSD_STRING.getDatatype(factory);
    OWLDatatype second = OWL2Datatype.XSD_DATE_TIME.getDatatype(factory);
    OWLDataIntersectionOf intersection = factory.getOWLDataIntersectionOf(first, second);

    OWLDataProperty property = factory.getOWLDataProperty(":intersectionOfOwl2Datatypes", pm);
    addToGenericDomainAndNewRange(property, intersection);
  }

  @Override
  public String getName() {
    return "owl:intersectionOf (Data Range, OWL 2)";
  }

  @Override
  public String getToken() {
    return "intersectionofowl2data";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_RANGE_EXPRESSIONS;
  }
}
