package de.linkvt.ontobench.features.axioms.dataproperty;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlAllDisjointDataPropertiesFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty p1 = factory.getOWLDataProperty(":allDisjointDataProperties_Property1", pm);
    OWLDataProperty p2 = factory.getOWLDataProperty(":allDisjointDataProperties_Property2", pm);
    OWLDataProperty p3 = factory.getOWLDataProperty(":allDisjointDataProperties_Property3", pm);

    addAxiomToOntology(factory.getOWLDisjointDataPropertiesAxiom(p1, p2, p3));

    OWLDatatype stringDatatype = OWL2Datatype.XSD_STRING.getDatatype(factory);
    addToGenericDomainAndNewRange(p1, stringDatatype);
    addToGenericDomainAndNewRange(p2, stringDatatype);
    addToGenericDomainAndNewRange(p3, stringDatatype);
  }

  @Override
  public String getName() {
    return "owl:AllDisjointProperties";
  }

  @Override
  public String getToken() {
    return "alldisjointpropertiesdata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTIES;
  }
}
