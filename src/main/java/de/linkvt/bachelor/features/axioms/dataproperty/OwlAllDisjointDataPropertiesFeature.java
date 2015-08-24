package de.linkvt.bachelor.features.axioms.dataproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlAllDisjointDataPropertiesFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty street = factory.getOWLDataProperty(":street", pm);
    OWLDataProperty name = factory.getOWLDataProperty(":name", pm);
    OWLDataProperty favoriteColor = factory.getOWLDataProperty(":favoriteColor", pm);

    addAxiomToOntology(factory.getOWLDisjointDataPropertiesAxiom(street, name, favoriteColor));

    OWLDatatype stringDatatype = OWL2Datatype.XSD_STRING.getDatatype(factory);
    addToGenericDomainAndNewRange(street, stringDatatype);
    addToGenericDomainAndNewRange(name, stringDatatype);
    addToGenericDomainAndNewRange(favoriteColor, stringDatatype);
  }

  @Override
  public String getName() {
    return "owl:AllDisjointProperties (Data Property)";
  }

  @Override
  public String getToken() {
    return "alldisjointpropertiesdata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTY_AXIOMS;
  }
}
