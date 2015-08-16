package de.linkvt.bachelor.features.axioms.dataproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlDataPropertyDisjointWithFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty icqNumber = factory.getOWLDataProperty(":icqNumber", pm);
    OWLDataProperty volume = factory.getOWLDataProperty(":volume", pm);

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
    return FeatureCategory.DATA_PROPERTY_AXIOMS;
  }
}
