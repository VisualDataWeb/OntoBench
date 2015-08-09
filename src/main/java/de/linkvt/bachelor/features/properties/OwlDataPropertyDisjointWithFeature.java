package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlDataPropertyDisjointWithFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty icqNumber = factory.getOWLDataProperty(IRI.create("icqNumber"));
    OWLDataProperty volume = factory.getOWLDataProperty(IRI.create("volume"));

    addAxiomToOntology(factory.getOWLDisjointDataPropertiesAxiom(icqNumber, volume));

    addToGenericDomainAndNewRange(icqNumber, factory.getIntegerOWLDatatype());
    addToGenericDomainAndNewRange(volume, factory.getFloatOWLDatatype());
  }

  @Override
  public String getName() {
    return "owl:propertyDisjointWith (Data Property)";
  }

  @Override
  public String getToken() {
    return "propertydisjointwithdata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.PROPERTY;
  }
}
