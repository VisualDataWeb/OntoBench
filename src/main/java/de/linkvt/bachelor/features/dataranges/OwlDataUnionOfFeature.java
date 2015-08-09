package de.linkvt.bachelor.features.dataranges;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataUnionOf;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataUnionOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDatatype evenIntegers = factory.getOWLDatatype(IRI.create("EvenIntegers"));
    OWLDatatype oddIntegers = factory.getOWLDatatype(IRI.create("OddIntegers"));
    OWLDataUnionOf union = factory.getOWLDataUnionOf(evenIntegers, oddIntegers);

    OWLDataProperty property = factory.getOWLDataProperty(IRI.create("unionOfPositiveAndOddIntegers"));
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
