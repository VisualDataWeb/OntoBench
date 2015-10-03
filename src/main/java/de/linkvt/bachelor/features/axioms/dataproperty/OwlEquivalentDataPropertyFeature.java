package de.linkvt.bachelor.features.axioms.dataproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlEquivalentDataPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty p1 = factory.getOWLDataProperty(":equivalentDataProperty_1", pm);
    OWLDataProperty p2 = factory.getOWLDataProperty(":equivalentDataProperty_2", pm);
    OWLDataProperty p3 = factory.getOWLDataProperty(":equivalentDataProperty_3", pm);

    addAxiomToOntology(factory.getOWLEquivalentDataPropertiesAxiom(p1, p2, p3));

    OWLDatatype datatype = OWL2Datatype.XSD_NON_NEGATIVE_INTEGER.getDatatype(factory);
    addToGenericDomainAndNewRange(p1, datatype);
    addToGenericDomainAndNewRange(p2, datatype);
    addToGenericDomainAndNewRange(p3, datatype);
  }

  @Override
  public String getName() {
    return "owl:equivalentProperty (Data Property)";
  }

  @Override
  public String getToken() {
    return "equivalentpropdata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTY_AXIOMS;
  }
}
