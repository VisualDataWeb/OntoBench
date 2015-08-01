package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

/**
 * Property without a domain.
 */
@Component
public class DomainlessPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass range = featurePool.getExclusiveClass("Range");
    OWLObjectProperty objectProperty = featurePool.getExclusiveProperty("HasNoDomain");
    OWLAxiom axiom = factory.getOWLObjectPropertyRangeAxiom(objectProperty, range);

    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:ObjectProperty without a domain";
  }

  @Override
  public String getToken() {
    return "domainless";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.PROPERTY;
  }
}
