package de.linkvt.ontobench.features.axioms.dataproperty;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLProperty;
import org.springframework.stereotype.Component;

/**
 * Data Property without domain and range.
 */
@Component
public class UnboundDataPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLProperty property = factory.getOWLDataProperty(":noDomainAndRangeDataProperty", pm);

    addAxiomToOntology(factory.getOWLDeclarationAxiom(property));
  }

  @Override
  public String getName() {
    return "owl:DatatypeProperty";
  }

  @Override
  public String getToken() {
    return "unbounddataprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTIES;
  }

  @Override
  public String getClarification() {
    return "without domain and range";
  }

  @Override
  public boolean isSpecialization() {
    return true;
  }
}
