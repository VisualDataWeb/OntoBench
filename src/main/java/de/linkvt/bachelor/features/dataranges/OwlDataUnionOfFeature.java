package de.linkvt.bachelor.features.dataranges;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataUnionOf;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataUnionOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDatatype evenIntegers = factory.getOWLDatatype(":EvenIntegers", pm);
    OWLDatatype oddIntegers = factory.getOWLDatatype(":OddIntegers", pm);
    OWLDataUnionOf union = factory.getOWLDataUnionOf(evenIntegers, oddIntegers);

    OWLDataProperty property = factory.getOWLDataProperty(":unionOfEvenAndOddIntegers", pm);
    addToGenericDomainAndNewRange(property, union);
  }

  @Override
  public String getName() {
    return "owl:unionOf (Data Range)";
  }

  @Override
  public String getToken() {
    return "uniondata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_RANGE_EXPRESSIONS;
  }
}
