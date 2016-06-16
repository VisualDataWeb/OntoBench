package de.linkvt.ontobench.features.axioms.objectproperty;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

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
    return "owl:ObjectProperty";
  }

  @Override
  public String getToken() {
    return "unboundobjectprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTIES;
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
