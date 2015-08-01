package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

/**
 * An owl transitive property.
 */
@Component
public class OwlTransitivePropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getReusablePropertyAndRemoveFromPool();
    OWLClass range = featurePool.getExclusiveClass("TransitivePropertyRange");
    addToGenericDomainAndNewRange(property, range);

    OWLAxiom axiom = factory.getOWLTransitiveObjectPropertyAxiom(property);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:TransitiveProperty";
  }

  @Override
  public String getToken() {
    return "transitiveprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.PROPERTY;
  }
}
