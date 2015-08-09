package de.linkvt.bachelor.features.classes.setoperators.data;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataIntersectionOf;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataIntersectionOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDatatype evenIntegers = factory.getOWLDatatype(IRI.create("EvenIntegers"));
    OWLDatatype oddIntegers = factory.getOWLDatatype(IRI.create("OddIntegers"));
    OWLDataIntersectionOf intersection = factory.getOWLDataIntersectionOf(evenIntegers, oddIntegers);

    OWLDataProperty property = factory.getOWLDataProperty(IRI.create("intersectionOfPositiveAndOddIntegers"));
    addToGenericDomainAndNewRange(property, intersection);
  }

  @Override
  public String getName() {
    return "owl:intersectionOf (Data Range)";
  }

  @Override
  public String getToken() {
    return "intersectiondata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS;
  }
}
