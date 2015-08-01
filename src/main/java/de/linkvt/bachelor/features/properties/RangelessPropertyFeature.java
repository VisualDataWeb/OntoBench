package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

/**
 * Property without a range.
 */
@Component
public class RangelessPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getExclusiveClass("Domain");
    OWLObjectProperty objectProperty = featurePool.getExclusiveProperty("HasNoRange");
    OWLAxiom axiom = factory.getOWLObjectPropertyDomainAxiom(objectProperty, domain);

    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:ObjectProperty without a range";
  }

  @Override
  public String getToken() {
    return "rangeless";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.PROPERTY;
  }
}
