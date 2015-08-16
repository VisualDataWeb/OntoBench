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
    OWLDataProperty age = factory.getOWLDataProperty(":age", pm);
    OWLDataProperty alter = factory.getOWLDataProperty(":alter", pm);
    OWLDataProperty edad = factory.getOWLDataProperty(":edad", pm);

    addAxiomToOntology(factory.getOWLEquivalentDataPropertiesAxiom(age, alter, edad));

    OWLDatatype datatype = OWL2Datatype.XSD_NON_NEGATIVE_INTEGER.getDatatype(factory);
    addToGenericDomainAndNewRange(age, datatype);
    addToGenericDomainAndNewRange(alter, datatype);
    addToGenericDomainAndNewRange(edad, datatype);
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
