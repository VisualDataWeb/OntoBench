package de.linkvt.bachelor.features.axioms.dataproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataPropertyDisjointWithFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty p1 = factory.getOWLDataProperty(":dataPropertyDisjointWith_Property1", pm);
    OWLDataProperty p2 = factory.getOWLDataProperty(":dataPropertyDisjointWith_Property2", pm);

    addAxiomToOntology(factory.getOWLDisjointDataPropertiesAxiom(p1, p2));

    addToGenericDomainAndNewRange(p1, factory.getIntegerOWLDatatype());
    addToGenericDomainAndNewRange(p2, OWL2Datatype.XSD_DECIMAL.getDatatype(factory));
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
    return FeatureCategory.DATA_PROPERTIES;
  }
}
