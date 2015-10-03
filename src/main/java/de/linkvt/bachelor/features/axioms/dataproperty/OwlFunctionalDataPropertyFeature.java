package de.linkvt.bachelor.features.axioms.dataproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlFunctionalDataPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty dataProperty = factory.getOWLDataProperty(":functionalDataProperty", pm);
    OWLDatatype datatype = OWL2Datatype.XSD_NON_NEGATIVE_INTEGER.getDatatype(factory);

    addToGenericDomainAndNewRange(dataProperty, datatype);
    addAxiomToOntology(factory.getOWLFunctionalDataPropertyAxiom(dataProperty));
  }

  @Override
  public String getName() {
    return "owl:FunctionalProperty (Data Property)";
  }

  @Override
  public String getToken() {
    return "functionalpropdata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTY_AXIOMS;
  }
}
