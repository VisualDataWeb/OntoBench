package de.linkvt.bachelor.features.classes.cardinalities.owllite;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlLiteOwlMaxCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getReusablePropertyAndRemoveFromPool();
    OWLClass range = featurePool.getExclusiveClass("MaxCardinalityRange");
    addToGenericDomainAndNewRange(property, range);

    OWLObjectMaxCardinality maxCardinality = factory.getOWLObjectMaxCardinality(1, property);
    OWLAxiom axiom = factory.getOWLSubClassOfAxiom(range, maxCardinality);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:maxCardinality (OWL Lite)";
  }

  @Override
  public String getToken() {
    return "maxcardinalitylite";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS;
  }
}
