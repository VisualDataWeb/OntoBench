package de.linkvt.bachelor.features.declarations;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLProperty;
import org.springframework.stereotype.Component;

/**
 * Data Property without domain and range.
 */
@Component
public class UnboundDataPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLProperty property = factory.getOWLDataProperty(IRI.create(":NoDomainAndRangeDataProperty"));

    addAxiomToOntology(factory.getOWLDeclarationAxiom(property));
  }

  @Override
  public String getName() {
    return "owl:DatatypeProperty without domain and range";
  }

  @Override
  public String getToken() {
    return "unbounddataprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DECLARATIONS;
  }
}
