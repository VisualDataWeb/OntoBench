package de.linkvt.bachelor.features.declarations;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLProperty;
import org.springframework.stereotype.Component;

/**
 * Object Property without domain and range.
 */
@Component
public class UnboundObjectPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLProperty property = featurePool.getExclusiveProperty(":noDomainAndRangeObjectProperty");
    OWLAxiom axiom = factory.getOWLDeclarationAxiom(property);

    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:ObjectProperty without domain and range";
  }

  @Override
  public String getToken() {
    return "unboundobjectprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DECLARATIONS;
  }
}
