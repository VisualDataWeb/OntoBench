package de.linkvt.bachelor.features.classes.cardinalities.owllite;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlLiteOwlMinCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getReusablePropertyAndRemoveFromPool();
    OWLClass range = featurePool.getExclusiveClass("MinCardinalityRange");
    addToGenericDomainAndNewRange(property, range);

    OWLObjectMinCardinality minCardinality = factory.getOWLObjectMinCardinality(0, property);
    OWLAxiom axiom = factory.getOWLSubClassOfAxiom(range, minCardinality);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:minCardinality (OWL Lite)";
  }

  @Override
  public String getToken() {
    return "mincardinalitylite";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS;
  }
}
