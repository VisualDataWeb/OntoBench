package de.linkvt.bachelor.features.classes.cardinalities.owllite;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlLiteOwlCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getReusablePropertyAndRemoveFromPool();
    OWLClass range = featurePool.getExclusiveClass("CardinalityRange");
    addToGenericDomainAndNewRange(property, range);

    OWLObjectExactCardinality exactCardinality = factory.getOWLObjectExactCardinality(1, property);
    OWLAxiom axiom = factory.getOWLSubClassOfAxiom(range, exactCardinality);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:cardinality (OWL Lite)";
  }

  @Override
  public String getToken() {
    return "cardinalitylite";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS;
  }
}
